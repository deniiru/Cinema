package org.example.Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

class DayTest {

    @Test
    void addMovie() {
        Day day = new Day("Monday");
        Movie movie = new Movie("Avatar", "SF", 120);

        day.addMovie(movie);
        Set<MovieSchedule> schedules = day.getSchedules();
        assertTrue(schedules.stream().anyMatch(schedule -> schedule.getMovie().getTitle().equals("Avatar")));
    }

    @Test
    void getName() {
        Day day = new Day("Tuesday");
        assertEquals("Tuesday", day.getName());
    }

    @Test
    void removeMovie() {
        Day day = new Day("Wednesday");
        Movie movie = new Movie("Avatar", "SF", 120);


        day.addMovie(movie);
        day.removeMovie("Avatar");

        Set<MovieSchedule> schedules = day.getSchedules();
        assertFalse(schedules.stream().anyMatch(schedule -> schedule.getMovie().getTitle().equals("Avatar")));
    }

    @Test
    void isPlaying() {
        Day day = new Day("Thursday");
        Movie movie = new Movie("Titanic", "romantic", 120);
        Room room = new Room("1", 3,3);

        day.addMovie(movie);
        day.add("Titanic", "15:00", room);

        Room result = day.isPlaying("Titanic", "15:00");
        assertNotNull(result);
        assertEquals("1", result.getName());
    }

    @Test
    void eraseMoviePlayTime() {
        Day day = new Day("Friday");
        Movie movie = new Movie("Titanic", "romantic", 120);
        Room room = new Room("1", 3,3);

        day.addMovie(movie);
        day.add("The Matrix", "18:00", room);
        day.eraseMoviePlayTime("The Matrix", "18:00");

        Room result = day.isPlaying("The Matrix", "18:00");
        assertNull(result);
    }
}
