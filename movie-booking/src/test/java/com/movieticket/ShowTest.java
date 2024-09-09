package com.movieticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowTest {

    private Show show;

    @BeforeEach
    void setUp() {
        List<Seat> seats = Arrays.asList(
                new Seat("A1", Category.Platinum), new Seat("A2", Category.Gold), new Seat("A3", Category.Silver)
        );
        show = new Show(1, seats);
    }

    @Test
    void testDisplayAvailableSeats() {
        show.displayAvailableSeats();
    }

    @Test
    void testBookSeats() {
        assertTrue(show.bookSeats(Arrays.asList("A1", "A2")));
        assertFalse(show.bookSeats(Arrays.asList("A1"))); // A1 is already booked
    }

    @Test
    void testCalculateSubtotal() {
        List<String> seatNumbers = Arrays.asList("A1", "A2", "A3");
        double expectedSubtotal = 320 + 280 + 240;
        assertEquals(expectedSubtotal, show.calculateSubtotal(seatNumbers));
    }
}
