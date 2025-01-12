package org.example.Classes;

import org.example.Interfaces.Schedulable;

import java.util.*;

public class MovieSchedule implements Schedulable {
    private Movie movie;
    private Map<String, Room> playTime;


    public MovieSchedule(Movie movie) {
        this.movie = movie;
        this.playTime = new HashMap<>();
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public void addPlayTime(String time, Room roomName) {
            playTime.put(time, roomName);
            System.out.println("Play time added: " + time + " in room: " + roomName.getName());
    }

    public void removePlayTime(String time) {
        if (playTime.remove(time) != null) {
            System.out.println("Play time '" + time + "' removed from the schedule.");
        } else {
            System.out.println("Play time '" + time + "' does not exist.");
        }
    }


    @Override
    public void displaySchedule() {
        Map<String, Room> sortedPlayTime = new TreeMap<>(playTime);

        System.out.println("Schedule for movie: " + movie.getTitle());
        for (Map.Entry<String, Room> entry : sortedPlayTime.entrySet()) {
            System.out.println("Time: " + entry.getKey() + " | Room: " + entry.getValue().getName());
        }
    }

    public String PlayTime() {
        StringBuilder result = new StringBuilder("Play times for movie '" + movie.getTitle() + "': ");
        for (String time : playTime.keySet()) {
            result.append(time).append(", ");
        }
        // Remove the trailing comma and space if there are play times
        if (!playTime.isEmpty()) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }

    // i need these functions for the set structure from day class
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieSchedule that = (MovieSchedule) o;
        return Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie);
    }

    @Override
    public Room isPlaying(String time){
        time = time.trim();
        if(playTime.containsKey(time))
            return playTime.get(time);
        return null;
    }
    public String buildScheduleString() {
        StringBuilder result = new StringBuilder("Movie: " + movie.getTitle() + "\nPlaytimes:\n");
        for (Map.Entry<String, Room> entry : playTime.entrySet()) {
            result.append(" - ").append(entry.getKey()).append(" in ").append(entry.getValue().getName()).append("\n");
        }
        if (playTime.isEmpty()) {
            result.append("No playtimes available.");
        }
        return result.toString();
    }

    public Map<String, Room> getPlayTime() {
        return playTime;
    }
}