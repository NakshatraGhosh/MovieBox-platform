package com.screening_service.screening_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/screening")
public class ScreeningController {



@Autowired
private ScreeningRepository screeningRepository;

@Autowired
private SeatClient seatClient;

ScreeningController(ScreeningRepository screeningRepository, SeatClient seatClient) {
    this.screeningRepository = screeningRepository;
    this.seatClient = seatClient;
}


@GetMapping("/getallseatsbyscreeningid/{screeningId}")
  List<Seat> getseatsbyScreeningId(@PathVariable Long screeningId) {

    return seatClient.getSeatsByScreeningId(screeningId);

}




@GetMapping("/getallscreening")
public List<Screening> getAllScreenings() {
    return screeningRepository.findAll();
}

@GetMapping("/getallscreeningbytheatreid")
public List<Screening> getAllScreeningsByTheatreId(@RequestParam Long theatreid) {
    return screeningRepository.findAll().stream()
            .filter(screening -> screening.getTheatreid().equals(theatreid))
            .toList();
}



@PostMapping("/createscreening")
public Screening createScreening(@RequestBody Screening screening) {
    return screeningRepository.save(screening);




}

}