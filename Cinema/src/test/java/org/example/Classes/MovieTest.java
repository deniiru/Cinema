package org.example.Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MovieTest {

    @Test
    void getTitle() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        String title = movie.getTitle();
        assertEquals("Inception", title, "The title should be 'Inception'");
    }

    @Test
    void getType() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        String type = movie.getType();
        assertEquals("Sci-Fi", type, "The type should be 'Sci-Fi'");
    }

    @Test
    void getDuration() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        int duration = movie.getDuration();
        assertEquals(148, duration, "The duration should be 148 minutes");
    }

    @Test
    void setTitle() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        movie.setTitle("Interstellar");
        assertEquals("Interstellar", movie.getTitle(), "The title should be updated to 'Interstellar'");
    }

    @Test
    void setType() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        movie.setType("Adventure");
        assertEquals("Adventure", movie.getType(), "The type should be updated to 'Adventure'");
    }

    @Test
    void setDuration() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        movie.setDuration(165);
        assertEquals(165, movie.getDuration(), "The duration should be updated to 165 minutes");
    }

}