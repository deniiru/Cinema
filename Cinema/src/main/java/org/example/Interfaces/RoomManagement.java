package org.example.Interfaces;

public interface RoomManagement {
    boolean bookSeat(int i, int j);
    boolean eraseBooking(int i, int j);
    void displaySeats();
    void displayAvailableSeats();
}
