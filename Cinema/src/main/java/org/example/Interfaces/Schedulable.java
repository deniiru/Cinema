package org.example.Interfaces;

import org.example.Classes.Room;

public interface Schedulable {
    void addPlayTime(String time, Room roomName);
    void displaySchedule();

    Room isPlaying(String playTime);
    void displayMovieRoom(String time);
}
