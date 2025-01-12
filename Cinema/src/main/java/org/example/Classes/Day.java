package org.example.Classes;

import java.util.HashSet;
import java.util.Set;

public class Day {
    private Set<MovieSchedule> schedules; // Set of MovieSchedule objects
    private String name;
    // Constructor
    public Day(String name) {
        schedules = new HashSet<>(); // Initialize the set
        this.name = name;
    }

    public void addMovie(Movie movie) {
        MovieSchedule newSchedule = new MovieSchedule(movie);
        if (schedules.add(newSchedule)) {
            System.out.println("Movie '" + movie.getTitle() + "' added to the schedule.");
        } else {
            System.out.println("Movie '" + movie.getTitle() + "' already exists in the schedule.");
        }
    }

    // Method to add a play time and room to an existing movie
    public void add(String movieName, String hour, Room room) {
        for (MovieSchedule schedule : schedules) {
            if (schedule.getMovie().getTitle().equals(movieName)) {
                schedule.addPlayTime(hour, room);
                return;
            }
        }
        System.out.println("Movie '" + movieName + "' is not in the schedule. Add it first.");
    }

    // Method to display all schedules
    public void displaySchedules() {
        System.out.println("Schedule for the day:");
        for (MovieSchedule schedule : schedules) {
            schedule.displaySchedule();
        }
    }

    public String getName() {
        return name;
    }

    public void removeMovie(String movie) {
        for ( MovieSchedule schedule : schedules) {
            if (schedule.getMovie().getTitle().equals(movie)) {
                schedules.remove(schedule);
                System.out.println("Movie '" + movie + "' removed from the schedule.");
            }
        }
    }

    public String buildDayScheduleString() {
        StringBuilder result = new StringBuilder("Schedule for " + name + ":\n");
        if (schedules.isEmpty()) {
            result.append("No movies scheduled.\n");
        } else {
            for (MovieSchedule schedule : schedules) {
                result.append(schedule.buildScheduleString()).append("\n");
            }
        }
        return result.toString();
    }

    public Room isPlaying(String movieName, String playTime){

        for (MovieSchedule schedule : schedules) {
            if (schedule.getMovie().getTitle().equals(movieName)) {
                return schedule.isPlaying(playTime);
            }
        }

        return null;
    }

    public Set<MovieSchedule> getSchedules() {
        return schedules;
    }

    public void eraseMoviePlayTime(String movieName, String playTime) {
        for (MovieSchedule schedule : schedules) {
            if (schedule.getMovie().getTitle().equals(movieName)) {
                schedule.removePlayTime(playTime);
            }
        }

    }

}
