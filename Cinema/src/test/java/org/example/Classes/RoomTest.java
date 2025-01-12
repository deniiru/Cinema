package org.example.Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void bookSeat() {
        Room room = new Room("TestRoom", 5, 5);

        boolean result1 = room.bookSeat(2, 3);
        boolean result2 = room.bookSeat(2, 3);
        boolean result3 = room.bookSeat(6, 3);

        assertTrue(result1, "Booking should be successful for valid seat.");
        assertFalse(result2, "Booking should fail for already booked seat.");
        assertFalse(result3, "Booking should fail for invalid seat.");
    }

    @Test
    void eraseBooking() {
        Room room = new Room("TestRoom", 5, 5);
        room.bookSeat(2, 3); // Book a seat to erase

        boolean result1 = room.eraseBooking(2, 3);
        boolean result2 = room.eraseBooking(2, 3);
        boolean result3 = room.eraseBooking(6, 3);

        assertTrue(result1, "Erasure should be successful for booked seat.");
        assertFalse(result2, "Erasure should fail for an already available seat.");
        assertFalse(result3, "Erasure should fail for invalid seat.");
    }

    @Test
    void displaySeats() {
        Room room = new Room("TestRoom", 3, 3);
        room.bookSeat(0, 0);
        room.bookSeat(1, 1);
        room.bookSeat(2, 2);

        room.displaySeats();
    }

    @Test
    void getAvailableSeats() {
        Room room = new Room("TestRoom", 5, 5); // Total seats = 25
        room.bookSeat(0, 0);
        room.bookSeat(1, 1);

        int availableSeats = room.getAvailableSeats();

        assertEquals(23, availableSeats, "Available seats should be correctly calculated.");
    }

    @Test
    void displayAvailableSeats() {
        Room room = new Room("TestRoom", 3, 3);
        room.bookSeat(0, 0);
        room.bookSeat(1, 1);

        room.displayAvailableSeats();
    }

    @Test
    void getName() {
        Room room = new Room("TestRoom", 5, 5);
        String name = room.getName();
        assertEquals("TestRoom", name, "Room name should be 'TestRoom'.");
    }

    @Test
    void setName() {
        Room room = new Room("TestRoom", 5, 5);
        room.setName("NewRoomName");
        assertEquals("NewRoomName", room.getName(), "Room name should be updated to 'NewRoomName'.");
    }
}
