package com.movieticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookingSystemTest {
    private BookingSystem bookingSystem;

    @BeforeEach
    void setUp() {
        bookingSystem = new BookingSystem();

        List<Seat> show1Seats = Arrays.asList(
                new Seat("A1", Category.Platinum), new Seat("A2", Category.Platinum), new Seat("A3", Category.Platinum),
                new Seat("A4", Category.Platinum), new Seat("A5", Category.Platinum), new Seat("A6", Category.Platinum),
                new Seat("A7", Category.Platinum), new Seat("A8", Category.Platinum), new Seat("A9", Category.Platinum),
                new Seat("B1", Category.Gold), new Seat("B2", Category.Gold), new Seat("B3", Category.Gold),
                new Seat("B4", Category.Gold), new Seat("B5", Category.Gold), new Seat("B6", Category.Gold),
                new Seat("C2", Category.Silver), new Seat("C3", Category.Silver), new Seat("C4", Category.Silver),
                new Seat("C5", Category.Silver), new Seat("C6", Category.Silver), new Seat("C7", Category.Silver)
        );
        bookingSystem.addShow(new Show(1, show1Seats));
    }

    @Test
    void testAddShow() {
        Show show = new Show(2, Arrays.asList(new Seat("A1", Category.Platinum)));
        bookingSystem.addShow(show);
        assertEquals(show, bookingSystem.getShow(2));
    }

    @Test
    void testGetShow() {
        Show show = bookingSystem.getShow(1);
        assertEquals(1, show.getShowNumber());
    }

    @Test
    void testPrintTotalSales() {
        bookingSystem.printTotalSales();
    }

    @Test
    void testBookTickets() {
        Show show = bookingSystem.getShow(1);
        List<String> seatNumbers = Arrays.asList("A1", "A2");
        assertTrue(show.bookSeats(seatNumbers));

        double subtotal = show.calculateSubtotal(seatNumbers);
        double serviceTax = subtotal * 0.14;
        double swachhBharatCess = subtotal * 0.005;
        double krishiKalyanCess = subtotal * 0.005;
        double total = subtotal + serviceTax + swachhBharatCess + krishiKalyanCess;

        assertEquals(320 + 320, subtotal);
        assertEquals((320 + 320) * 0.14, serviceTax);
        assertEquals((320 + 320) * 0.005, swachhBharatCess);
        assertEquals((320 + 320) * 0.005, krishiKalyanCess);
        assertEquals(subtotal + serviceTax + swachhBharatCess + krishiKalyanCess, total);
    }
}
