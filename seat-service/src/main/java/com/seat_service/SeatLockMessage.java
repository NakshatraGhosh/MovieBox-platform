package com.seat_service;
public class SeatLockMessage {
    private long seatid;

    public SeatLockMessage() {}
    public SeatLockMessage(long seatid) { this.seatid = seatid; }
    public long getSeatid() { return seatid; }
    public void setSeatid(long seatid) { this.seatid = seatid; }
}