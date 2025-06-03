package com.Theatre.Theatre.service;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    
  transient private List<Screening> screenings;

    public List<Screening> getScreenings() {
        return screenings;
    }
    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }
    private long locationid;

    public long getLocationid() {
        return locationid;
    }

    public void setLocationid(long locationid) {
        this.locationid = locationid;
    }

    // Constructor
    public Theatre() {
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theatre(Long id, String name, long locationid, List<Screening> screenings) {
        this.screenings = screenings;
        this.id = id;
        this.name = name;
        this.locationid = locationid;

        
    }

}
