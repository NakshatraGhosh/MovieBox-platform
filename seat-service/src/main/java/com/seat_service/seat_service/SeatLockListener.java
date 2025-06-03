package com.seat_service.seat_service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seat_service.SeatLockMessage;

import java.time.LocalDateTime;

@Component
public class SeatLockListener {

    @Autowired
    private SeatRepository seatRepository;

    @RabbitListener(queues = "seat-lock-queue")
    public void handleSeatLockRelease(SeatLockMessage message) {
        SEAT seat = seatRepository.findById(message.getSeatid()).orElse(null);
        if (seat != null && !seat.isStatus()) {
            // If still not booked, unlock
            seat.setLockedUntil(null);
            seatRepository.save(seat);
        }
    }
}