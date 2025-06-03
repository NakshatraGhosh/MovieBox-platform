package com.seat_service.seat_service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seat_service.SeatLockMessage;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    // Add your endpoint methods here
    // For example, to get all seats:
     @GetMapping("/getallseats")
    public List<SEAT> getAllSeats() {
        return seatRepository.findAll();
    }
    @GetMapping("/getseatbyid/{id}")
    public SEAT getSeatById(@PathVariable Long id) {
        return seatRepository.findById(id).orElse(null);
    }

    @GetMapping("/getseatsbyScreeningId/{screeningId}")
    public List<SEAT> getSeatsByScreeningId(@PathVariable Long screeningid) {
        return seatRepository.findByscreeningid(screeningid);
    }

    @PostMapping("/createseat")
    public SEAT createSeat(@RequestBody SEAT seat) {
        return seatRepository.save(seat);
    }

    @PostMapping("/addseatsbulk")
    public List<SEAT> addSeatsBulk(@RequestBody List<SEAT> seats) {
        return seatRepository.saveAll(seats);
    }


@Autowired
private RabbitTemplate rabbitTemplate;

@PostMapping("/select/{seatid}")
public String selectSeat(@PathVariable long seatid) {
    Optional<SEAT> seatOpt = seatRepository.findById(seatid);
    if (seatOpt.isEmpty()) return "Seat not found";

    SEAT seat = seatOpt.get();
    LocalDateTime now = LocalDateTime.now();

    if (!seat.isStatus() && (seat.getLockedUntil() == null || seat.getLockedUntil().isBefore(now))) {
        seat.setLockedUntil(now.plusMinutes(5));
        seatRepository.save(seat);

        // Send delayed message to queue (5 minutes = 300000 ms)
        rabbitTemplate.convertAndSend("seat-lock-exchange", "seat.lock.release", 
            new SeatLockMessage(seatid), 
            message -> {
                message.getMessageProperties().setDelayLong(300000L);
                return message;
            });

        return "Seat locked for 5 minutes";
    } else {
        return "Seat is not available";
    }

    
}
}
