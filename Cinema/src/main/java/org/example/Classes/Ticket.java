package org.example.Classes;

import java.util.ArrayList;

// Class to encapsulate ticket details
public class Ticket {
    private String date;
    private String movieName;
    private String roomName;
    private Seat seat;

    public Ticket(String date, String movieName, String roomName, Seat seat) {
        this.date = date;
        this.movieName = movieName;
        this.roomName = roomName;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Movie: " + movieName + ", Room: " + roomName + ", Seat: " + seat.toString();
    }

    public void display()
    {
        System.out.println(toString());
    }
}


