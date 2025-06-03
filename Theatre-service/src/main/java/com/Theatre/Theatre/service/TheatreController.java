package com.Theatre.Theatre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    private Theatrerepository theatreRepository;

    @Autowired
    private ScreeningClient screeningClient;

    @GetMapping("/getallscreeningbytheatreid/{theatreid}")
    public List<Screening> getAllScreeningsByTheatreId(@PathVariable Long theatreid) {
        return screeningClient.getAllScreeningsByTheatreId(theatreid);
    }
   
    @GetMapping("/getallscreening")
    public List<Screening> getAllScreenings() {
        return screeningClient.getAllScreenings();
    }
    

    @GetMapping
    public List<Theatre> getAllTheatres() {
        List<Theatre>list=theatreRepository.findAll();
        list.stream().forEach(theatre -> {
            List<Screening> screenings = screeningClient.getAllScreeningsByTheatreId(theatre.getId());
            theatre.setScreenings(screenings);
        });
        return list;
    }

    @GetMapping("/{id}")
    public Optional<Theatre> getTheatreById(@PathVariable Long id) {
        return theatreRepository.findById(id);
    }

    @PostMapping
    public Theatre createTheatre(@RequestBody Theatre theatre) {
        return theatreRepository.save(theatre);
    }


    @DeleteMapping("/{id}")
    public void deleteTheatre(@PathVariable Long id) {
        theatreRepository.deleteById(id);
    }


@GetMapping("/location/{locationid}")
public List<Theatre> getTheatreByLocationId(@PathVariable Long locationid) {
    return theatreRepository.findByLocationid(locationid);
}


   
}



