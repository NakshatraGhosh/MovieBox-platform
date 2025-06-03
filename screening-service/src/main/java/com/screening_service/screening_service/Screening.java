package com.screening_service.screening_service;
import java.util.List;

import org.springframework.boot.context.metrics.buffering.StartupTimeline;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screeningid;
   
    private String screeningname;
   

    transient private List<Seat> seats;

    private String screeningendtime;
    private String screeningstarttime;
   
    private Long theatreid;

    public Screening() {
    }

    public Screening(Long screeningid, String screeningname, String screeningendtime, String screeningstarttime, Long theatreid) {
        this.screeningid = screeningid;
        this.screeningname = screeningname;
        this.screeningendtime = screeningendtime;
        this.screeningstarttime = screeningstarttime;
        this.theatreid = theatreid;
    }

    public Long getScreeningid() {
        return screeningid;
    }

    public void setScreeningid(Long screeningid) {
        this.screeningid = screeningid;
    }

    public String getScreeningname() {
        return screeningname;
    }

    public void setScreeningname(String screeningname) {
        this.screeningname = screeningname;
    }

    public String getScreeningendtime() {
        return screeningendtime;
    }

    public void setScreeningendtime(String screeningendtime) {
        this.screeningendtime = screeningendtime;
    }

    public String getScreeningstarttime() {
        return screeningstarttime;
    }

    public void setScreeningstarttime(String screeningstarttime) {
        this.screeningstarttime = screeningstarttime;
    }

    public Long getTheatreid() {
        return theatreid;
    }

    public void setTheatreid(Long theatreid) {
        this.theatreid = theatreid;
    }




}
