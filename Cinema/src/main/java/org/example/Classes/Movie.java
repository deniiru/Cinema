package org.example.Classes;

import java.util.Objects;

public class Movie {
    private String title;
    private String type;
    private int duration; // in minutes

    public Movie(String title, String type, int duration) {
        this.title = title;
        this.type = type;
        this.duration = duration;
    }

    public void displayMovie() {
        System.out.println("Title: " + title + ", Genre: " + type + ", Duration: " + duration + " mins");
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // i need these functions for the set structure from day class
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
