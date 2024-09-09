package com.movieticket;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Show {
    private int showNumber;
    private Map<String, Seat> seats;

    public Show(int showNumber, List<Seat> seatList) {
        this.showNumber = showNumber;
        seats = new LinkedHashMap<>();
        for (Seat seat : seatList) {
            seats.put(seat.getSeatNumber(), seat);
        }
    }

    public void displayAvailableSeats() {
        System.out.println("Available Seats:");
        for (Seat seat : seats.values()) {
            if (!seat.isBooked()) {
                System.out.print(seat.getSeatNumber() + " ");
            }
        }
        System.out.println();
    }

    public boolean bookSeats(List<String> seatNumbers) {
        for (String seatNumber : seatNumbers) {
            if (!seats.containsKey(seatNumber) || seats.get(seatNumber).isBooked()) {
                System.out.println(seatNumber + " Not available, Please select different seats");
                return false;
            }
        }
        for (String seatNumber : seatNumbers) {
            seats.get(seatNumber).bookSeat();
        }
        return true;
    }

    public int getShowNumber() {
        return showNumber;
    }

    public double calculateSubtotal(List<String> seatNumbers) {
        double subtotal = 0;
        for (String seatNumber : seatNumbers) {
            Category type = seats.get(seatNumber).getType();
            switch (type) {
                case Platinum:
                    subtotal += 320;
                    break;
                case Gold:
                    subtotal += 280;
                    break;
                case Silver:
                    subtotal += 240;
                    break;
            }
        }
        return subtotal;
    }
}

