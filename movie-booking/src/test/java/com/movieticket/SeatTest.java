package com.movieticket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    @Test
    void testBookSeat() {
        Seat seat = new Seat("A1", Category.Platinum);
        assertFalse(seat.isBooked());
        seat.bookSeat();
        assertTrue(seat.isBooked());
    }

    @Test
    void testSeatCategory() {
        Seat seat = new Seat("A1", Category.Gold);
        assertEquals("Gold", seat.getType());
    }
}
