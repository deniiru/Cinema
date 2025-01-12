package org.example.Classes;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MovieScheduleTest {

    @Test
    void getMovie() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        MovieSchedule schedule = new MovieSchedule(movie);
        Movie result = schedule.getMovie();

        assertEquals(movie, result, "The movie should match the one provided to the schedule.");
    }

    @Test
    void addPlayTime() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        MovieSchedule schedule = new MovieSchedule(movie);
        Room room = new Room("Room A", 10, 10);

        schedule.addPlayTime("14:00", room);

        Map<String, Room> playTime = schedule.getPlayTime();
        assertTrue(playTime.containsKey("14:00"), "Play time should be added to the schedule.");
        assertEquals(room, playTime.get("14:00"), "Room should match the one added for the play time.");
    }

    @Test
    void removePlayTime() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        MovieSchedule schedule = new MovieSchedule(movie);
        Room room = new Room("Room A", 10, 10);
        schedule.addPlayTime("14:00", room);

        schedule.removePlayTime("14:00");

        Map<String, Room> playTime = schedule.getPlayTime();
        assertFalse(playTime.containsKey("14:00"), "Play time should be removed from the schedule.");
    }

    @Test
    void displaySchedule() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        MovieSchedule schedule = new MovieSchedule(movie);
        Room roomA = new Room("Room A", 10, 10);
        Room roomB = new Room("Room B", 15, 15);

        schedule.addPlayTime("14:00", roomA);
        schedule.addPlayTime("16:30", roomB);

        schedule.displaySchedule();
    }

    @Test
    void isPlaying() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        MovieSchedule schedule = new MovieSchedule(movie);
        Room room = new Room("Room A", 10, 10);
        schedule.addPlayTime("14:00", room);

        Room result1 = schedule.isPlaying("14:00");
        Room result2 = schedule.isPlaying("16:00");

        assertEquals(room, result1, "Room should be returned for the specified play time.");
        assertNull(result2, "Null should be returned for a play time not in the schedule.");
    }

    @Test
    void buildScheduleString() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        MovieSchedule schedule = new MovieSchedule(movie);
        Room roomA = new Room("Room A", 10, 10);
        Room roomB = new Room("Room B", 15, 15);

        schedule.addPlayTime("14:00", roomA);
        schedule.addPlayTime("16:30", roomB);

        String result = schedule.buildScheduleString();

        String expected = "Movie: Inception\nPlaytimes:\n - 14:00 in Room A\n - 16:30 in Room B\n";
        System.out.println(result);
        assertEquals(expected, result, "The schedule string should match the expected format.");
    }
}