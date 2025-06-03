// Package: com.example.demo.model
package com.screening_service.screening_service;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Seat {


    private long seatid;
    private String seatnumber;
    
     private long seatcost;
    private long screeningid;
    private long theatreid;


    public long getSeatcost() {
        return seatcost;
    }

    public void setSeatcost(long seatcost) {
        this.seatcost = seatcost;
    }

    public Seat(long seatid, String seatnumber, long seatcost, long screeningid, long theatreid) {
        this.seatid = seatid;
        this.seatnumber = seatnumber;
        this.seatcost = seatcost;
        this.screeningid = screeningid;
        this.theatreid = theatreid;
    }
    // Constructor
    public Seat() {
    }
  
    // Getters and Setters
    public long getSeatid() {
        return seatid;
    }
    public void setSeatid(long seatid) {
        this.seatid = seatid;
    }
    public String getSeatnumber() {
        return seatnumber;
    }
    public void setSeatnumber(String seatnumber) {
        this.seatnumber= seatnumber;
    }
    public long getScreeningid() {
        return screeningid;
    }
    public void setScreeningid(long screeningid) {
        this.screeningid = screeningid;
    }
    public long getTheatreid() {
        return theatreid;
    }
    public void setTheatreid(long theatreid) {
        this.theatreid = theatreid;
    }
    




}
