package com.screening_service.screening_service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SEAT-SERVICE")
public interface SeatClient {
   
    @GetMapping("/seats/screening/{screeningId}")
    List<Seat> getSeatsByScreeningId(@PathVariable("screeningId") Long screeningId);

}
