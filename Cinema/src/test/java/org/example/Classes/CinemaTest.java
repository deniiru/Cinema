package org.example.Classes;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {

    @Test
    void eraseMovie() {
        Cinema cinema = new Cinema();
        Movie movie = new Movie("Avatar", "SF", 120);

        cinema.addMovieToDay(movie, "Tuesday");
        cinema.eraseMovie("Avatar", "Tuesday");

        Day tuesday = cinema.getDays().stream()
                .filter(day -> day.getName().equals("Tuesday"))
                .findFirst()
                .orElse(null);

        assertNotNull(tuesday);
        assertFalse(tuesday.getSchedules().stream()
                .anyMatch(schedule -> schedule.getMovie().getTitle().equals("Avatar")));
    }

    @Test
    void findRoom() {
        Cinema cinema = new Cinema();
        Movie movie = new Movie("Avatar", "SF", 120);
        Room room = new Room("Room1", 10, 10);

        cinema.addRoom("Room1", 10, 10);
        cinema.addMovieToDay(movie, "Wednesday");
        cinema.addPlayTimeToDay("Avatar", "20:00", "Room1", "Wednesday");

        Room foundRoom = cinema.findRoom("Wednesday", "Avatar", "20:00");
        assertEquals("Room1", foundRoom.getName());
    }

    @Test
    void saveToFile() {
        Cinema cinema = new Cinema();
        cinema.addRoom("Room1", 10, 10);
        Movie movie = new Movie("Avatar", "SF", 120);
        cinema.addMovieToDay(movie, "Thursday");

        File file = new File("cinema_data.txt");
        if (file.exists()) {
            file.delete(); // Remove existing file for a clean test
        }

        cinema.saveToFile();
        assertTrue(file.exists());
    }

    @Test
    void loadFromFile() {
        Cinema cinema = new Cinema();
        cinema.addRoom("Room1", 10, 10);
        Movie movie = new Movie("Avatar", "SF", 120);
        cinema.addMovieToDay(movie, "Friday");
        cinema.saveToFile();

        Cinema loadedCinema = new Cinema();
        loadedCinema.loadFromFile();

        assertEquals(cinema.getDays().size(), loadedCinema.getDays().size());
        assertEquals(cinema.getDays().get(4).getSchedules().size(),
                loadedCinema.getDays().get(4).getSchedules().size());
    }
}
