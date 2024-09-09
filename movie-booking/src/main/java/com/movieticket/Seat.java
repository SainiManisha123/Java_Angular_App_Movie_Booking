package com.movieticket;

public class Seat {
    private String seatNumber;
    private Category type;
    private boolean isBooked;

    public Seat(String seatNumber, Category type) {
        this.seatNumber = seatNumber;
        this.type = type;
        this.isBooked = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public Category getType() {
        return type;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookSeat() {
        this.isBooked = true;
    }
}

