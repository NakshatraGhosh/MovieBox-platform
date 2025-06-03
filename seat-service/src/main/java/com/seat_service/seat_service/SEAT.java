package com.seat_service.seat_service;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SEAT {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seatid;
    private String seatnumber;
    
     private long seatcost;
    private long screeningid;
    private long theatreid;


    private LocalDateTime lockedUntil; // null if not locked

public LocalDateTime getLockedUntil() {
    return lockedUntil;
}

public void setLockedUntil(LocalDateTime lockedUntil) {
    this.lockedUntil = lockedUntil;
}
    
private boolean status; // true = booked, false = available

  

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public SEAT(long seatid, String seatnumber, long seatcost, long screeningid, long theatreid, boolean status) {
        this.seatid = seatid;
        this.seatnumber = seatnumber;
        this.seatcost = seatcost;
        this.screeningid = screeningid;
        this.theatreid = theatreid;
        this.status = status;
    }


    public long getSeatcost() {
        return seatcost;
    }

    public void setSeatcost(long seatcost) {
        this.seatcost = seatcost;
    }

    public void setStatus() {
        this.status = status;
    }
    // Constructor
    public SEAT() {
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
