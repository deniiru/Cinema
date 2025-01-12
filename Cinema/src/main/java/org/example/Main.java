package org.example;

import org.example.Classes.Cinema;
import org.example.Classes.Customer;
import org.example.Classes.Movie;
import org.example.Classes.Ticket;
import org.example.Interfaces.CinemaManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CinemaManagement cinema = new Cinema();
        cinema.loadFromFile();
        boolean exit = false;

        while (!exit) {
            // Display the menu
            System.out.println("\nCinema Management Menu:");
            System.out.println("1. Add a Room");
            System.out.println("2. Add a Movie to a Day");
            System.out.println("3. Add a Play Time to a Day");
            System.out.println("4. Display Cinema Details");
            System.out.println("5. Book a ticket");
            System.out.println("6. Exit");
            System.out.println("7. Erase movie play time ");
            System.out.println("8. Erase movie");
            System.out.print("Choose an option (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Switch statement for menu options
            switch (choice) {
                case 1: // Add a Room
                    System.out.print("Enter room name: ");
                    String roomName = scanner.nextLine();
                    System.out.print("Enter number of rows: ");
                    int rows = scanner.nextInt();
                    System.out.print("Enter number of columns: ");
                    int cols = scanner.nextInt();
                    cinema.addRoom(roomName, rows, cols);
                    break;

                case 2: // Add a Movie to a Day
                    System.out.print("Enter movie title: ");
                    String movieTitle = scanner.nextLine();

                    System.out.print("Enter movie duration (in minutes): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter movie type: ");
                    String type = scanner.nextLine();

                    System.out.print("Enter day name: ");
                    String dayName = scanner.nextLine();

                    Movie movie = new Movie(movieTitle, type, duration);
                    cinema.addMovieToDay(movie, dayName);
                    break;

                case 3: // Add a Play Time to a Day
                    System.out.print("Enter movie name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter play time: ");
                    String playTime = scanner.nextLine();
                    System.out.print("Enter room name: ");
                    String playRoomName = scanner.nextLine();
                    System.out.print("Enter day name: ");
                    String playDayName = scanner.nextLine();
                    cinema.addPlayTimeToDay(movieName, playTime, playRoomName, playDayName);
                    break;

                case 4: // Display Cinema Details
                    cinema.displayCinemaDetails();
                    break;

                case 5:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter customer phone: ");
                    String phoneNumber = scanner.nextLine();

                    Customer customer = new Customer(name, phoneNumber);

                    System.out.print("Enter a day : ");
                    String day = scanner.nextLine();

                    System.out.print("Enter movie title: ");
                    String nameMovie = scanner.nextLine();

                    System.out.print("Enter play time: ");
                    String time =  scanner.nextLine();

                    Ticket  tichet = cinema.bookTicket(day, nameMovie, time);
                    if (tichet != null) {
                        customer.addTicket(tichet);
                    }
                    else
                        System.out.println("There are no more tichets");
                    break;

                case 6: // Exit
                    exit = true;
                    System.out.println("Exiting Cinema Management. Goodbye!");
                    break;

                case 7: // Exit
                    System.out.println("Enter movie name");
                    String titleMovie = scanner.nextLine();

                    System.out.print("Enter play time: ");
                    String play = scanner.nextLine();

                    System.out.print("Enter day name: ");
                    String day2= scanner.nextLine();

                    cinema.erasePlayTime(titleMovie, play, day2);
                    break;
                case 8:
                    System.out.println("Enter movie name");
                    String titleMovie2 = scanner.nextLine();
                    System.out.print("Enter day: ");
                    String day3 = scanner.nextLine();

                    cinema.eraseMovie(titleMovie2, day3);
                    break;
                default: // Invalid option
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            cinema.saveToFile();
        }

        scanner.close();
    }
}