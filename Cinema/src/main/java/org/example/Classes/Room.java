package org.example.Classes;

import org.example.Interfaces.RoomManagement;


public class Room implements RoomManagement{
        private String name;
        private int[][] seats;
        private int availableSeats;


        public Room(String name, int rows, int cols) {
            this.name = name;
            this.seats = new int[rows][cols]; // Initialize the matrix with 0
            this.availableSeats = rows * cols;
        }

        @Override
        public boolean bookSeat(int i, int j) {
            if (isValidSeat(i, j)) {
                if (seats[i][j] == 0) {
                    seats[i][j] = 1; // Mark the seat as booked
                    System.out.println("Seat at (" + i + ", " + j + ") booked successfully.");
                    availableSeats--;
                    return true;
                } else {
                    System.out.println("Seat at (" + i + ", " + j + ") is already booked.");
                    return false;
                }
            } else {
                System.out.println("Invalid seat position (" + i + ", " + j + ").");
                return false;
            }
        }

        @Override
        public boolean eraseBooking(int i, int j) {
            if (isValidSeat(i, j)) {
                if (seats[i][j] == 1) {
                    seats[i][j] = 0; // Mark the seat as available
                    System.out.println("Seat at (" + i + ", " + j + ") is now available.");
                    return true;
                } else {
                    System.out.println("Seat at (" + i + ", " + j + ") was not booked.");
                    return false;
                }
            } else {
                System.out.println("Invalid seat position (" + i + ", " + j + ").");
                return false;
            }
        }

        // Helper method to check if a seat position is valid
        private boolean isValidSeat(int i, int j) {
            return i >= 0 && i < seats.length && j >= 0 && j < seats[0].length;
        }

        @Override
        public void displaySeats() {
            System.out.println("Seating arrangement for room: " + name);
            for (int[] row : seats) {
                for (int seat : row) {
                    System.out.print(seat + " ");
                }
                System.out.println();
            }
        }

        public int getAvailableSeats() {
            return availableSeats;
        }

    @Override
    public void displayAvailableSeats() {

    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
