package com.Theatre.Theatre.service;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SCREENING-SERVICE")
public interface ScreeningClient {

    @GetMapping("/getallscreeningbytheatreid")
    List<Screening> getAllScreeningsByTheatreId(@RequestParam Long theatreid);

    @GetMapping("/getallscreening")
    List<Screening> getAllScreenings();



}
