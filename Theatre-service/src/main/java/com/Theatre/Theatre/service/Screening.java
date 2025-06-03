package com.Theatre.Theatre.service;

import org.springframework.boot.context.metrics.buffering.StartupTimeline;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Screening {

    private Long screeningid;
   
    private String screeningname;
   

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
