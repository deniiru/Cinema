package org.example.Classes;

import org.example.Interfaces.CinemaManagement;

import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.IOException;

public class Cinema implements CinemaManagement {
    private List<Day> days;
    private List<Room> rooms;
    private static final String CINEMA_DATA_FILE = "C:/Users/Rujoiu Cristina/Desktop/facultate/Anul 2/MIP/MIP_final_project/src/cinema_data.txt";

    // Constructor
    public Cinema() {
        days = new ArrayList<>();   // Initialize the list of days
        rooms = new ArrayList<>();  // Initialize the list of rooms

        // Initialize days with the names of the days of the week
        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String dayName : dayNames) {
            days.add(new Day(dayName));
        }
    }

    @Override
    public void addRoom(String roomName, int rows, int cols) {
        Room room = new Room(roomName, rows, cols);
        rooms.add(room);
        System.out.println("Room '" + room.getName() + "' added to the cinema.");
    }

    @Override
    public void addMovieToDay(Movie movie, String dayName) {
        for (Day day : days) {
            if (day.getName().equalsIgnoreCase(dayName)) {
                day.addMovie(movie);
                System.out.println("Movie '" + movie.getTitle() + "' added to " + dayName + ".");
                return;
            }
        }
        System.out.println("Invalid day name: " + dayName);
    }

    @Override
    public void addPlayTimeToDay(String movieName, String hour, String roomName, String dayName) {

        Room playRoom = null;
        for (Room room : rooms) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                playRoom = room;
                break;
            }
        }
        if (playRoom == null) {
            System.out.println("Room '" + roomName + "' does not exist in the cinema.");
            return;
        }

        for (Day day : days) {
            if (day.getName().equalsIgnoreCase(dayName)) {
                day.add(movieName, hour, playRoom);
                return;
            }
        }
        System.out.println("Day '" + dayName + "' is not in the cinema schedule.");
    }

    @Override
    public void erasePlayTime(String movieName, String hour, String dayName) {
        for (Day day : days) {
            if (day.getName().equalsIgnoreCase(dayName)) {
                day.eraseMoviePlayTime(movieName, hour);
            }
        }
    }


    @Override
    public void eraseMovie(String movie, String dayName)
    {
        for (Day day : days) {
            if (day.getName().equalsIgnoreCase(dayName)) {
                day.removeMovie(movie);
            }
        }
    }
    @Override
    public void displayCinemaDetails() {
        System.out.println("Cinema Details:");
        System.out.println("Rooms:");
        for (Room room : rooms) {
            System.out.println("- " + room.getName());
        }

        System.out.println("\nSchedule:");
        for (int i = 0; i < days.size(); i++) {
            System.out.println(days.get(i).getName());
            days.get(i).displaySchedules();
            System.out.println("------------------------------------------------------------------------------");
        }
    }

    @Override
    public Ticket bookTicket(String date, String movieName, String playTime)
    {
        Room room = findRoom(date,movieName, playTime);
       if (room != null)
       {
           if (room.getAvailableSeats()!= 0)
           {
               room.displaySeats();
               Seat seat = chooseSeat(room);
               if (room.bookSeat(seat.getRow(), seat.getColumn()))
               {
                   Ticket ticket = new Ticket(date, movieName, room.getName(), seat);
                   return ticket;
               }
               System.out.println("Seat does not exist in the cinema.");
               return null;
           }
           System.out.println("Room '" + room.getName() + "' does not exist in the cinema.");
           return null;

       }
       return null;
    }

    public Seat chooseSeat (Room room){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose seat:");
        System.out.println("Enter row ");
        int row = scanner.nextInt();
        System.out.println("Enter col ");
        int col = scanner.nextInt();
        return new Seat(row, col);
    }
    public Room findRoom (String date, String movieName, String playTime)
    {
        for ( Day day : days)
            if (day.getName().equals(date))
            {
                return day.isPlaying(movieName, playTime);
            }
        return null;
    }

    public List<Day> getDays() {
        return days;
    }

    @Override
    public void saveToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Create Gson instance with pretty printing
        try (FileWriter writer = new FileWriter(CINEMA_DATA_FILE)) {
            gson.toJson(this, writer);
            System.out.println("Cinema information saved");
        } catch (IOException e) {
            System.err.println("Failed to save cinema information: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(CINEMA_DATA_FILE)) {
            // Deserialize JSON into a temporary Cinema object
            Cinema loadedCinema = gson.fromJson(reader, Cinema.class);

            // Update the current object's fields
            this.days = loadedCinema.days;
            this.rooms = loadedCinema.rooms;

            System.out.println("Cinema information loaded successfully");
        } catch (IOException e) {
            System.err.println("Failed to load cinema information: " + e.getMessage());
        }
    }

    @Override
    public void viewMovieRoom(String day, String movieName, String playTime)
    {
        for (Day day1 : days) {
            if (day1.getName().equals(day))
            {
                day1.displayMovieRoom(movieName, playTime);
            }
        }
    }
}
