package org.example.Interfaces;

import org.example.Classes.Movie;
import org.example.Classes.Room;
import org.example.Classes.Ticket;

public interface CinemaManagement {
    void addRoom(String roomName, int rows, int cols);
    void addMovieToDay(Movie movie, String dayName);
    void eraseMovie(String movie, String day);

    void addPlayTimeToDay(String movieName, String hour, String roomName, String dayName);
    void erasePlayTime(String movieName, String hour, String dayName);
    void displayCinemaDetails();

    Ticket bookTicket(String date, String movieName, String playTime);

    void saveToFile();
    void loadFromFile();
}
