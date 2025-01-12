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
            displayMenu();

            int choice = getValidChoice(scanner);

            switch (choice) {
                case 1: cinema.displayCinemaDetails(); break;
                case 2: addRoom(scanner, cinema); break;
                case 3: addMovieToDay(scanner, cinema); break;
                case 4: addPlayTimeToDay(scanner, cinema);break;
                case 5: bookTicket(scanner, cinema); break;
                case 6: erasePlayTime(scanner, cinema); break;
                case 7: eraseMovie(scanner, cinema); break;
                case 8: viewRoomForMovie(scanner, cinema); break;
                case 9:
                    exit = true;
                    System.out.println("Exiting Cinema Management. Goodbye!");
                    break;
                default: System.out.println("Invalid option. Please try again.");
                break;
            }

            cinema.saveToFile();
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\nCinema Management Menu:");
        System.out.println("1. Display Cinema Details");
        System.out.println("2. Add a Room");
        System.out.println("3. Add a Movie to a Day");
        System.out.println("4. Add a Play Time to a Day");
        System.out.println("5. Book a Ticket");
        System.out.println("6. Erase Movie Play Time");
        System.out.println("7. Erase Movie");
        System.out.println("8. View Room for a Movie");
        System.out.println("9. Exit");
        System.out.print("Choose an option (1-9): ");
    }

    private static int getValidChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 9.");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    private static void addRoom(Scanner scanner, CinemaManagement cinema) {
        scanner.nextLine();
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        cinema.addRoom(roomName, rows, cols);
    }

    private static void addMovieToDay(Scanner scanner, CinemaManagement cinema) {
        scanner.nextLine();
        System.out.print("Enter movie title: ");
        String movieTitle = scanner.nextLine();

        System.out.print("Enter movie duration (in minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter movie type: ");
        String type = scanner.nextLine();

        System.out.print("Enter day name: ");
        String dayName = scanner.nextLine();

        Movie movie = new Movie(movieTitle, type, duration);
        cinema.addMovieToDay(movie, dayName);
        System.out.println("Movie added successfully.");
    }

    private static void addPlayTimeToDay(Scanner scanner, CinemaManagement cinema) {
        scanner.nextLine();
        System.out.print("Enter movie name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter play time: ");
        String playTime = scanner.nextLine();

        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();

        System.out.print("Enter day name: ");
        String dayName = scanner.nextLine();

        cinema.addPlayTimeToDay(movieName, playTime, roomName, dayName);
        System.out.println("Play time added successfully.");
    }

    private static void bookTicket(Scanner scanner, CinemaManagement cinema) {
        scanner.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer phone: ");
        String customerPhone = scanner.nextLine();

        Customer customer = new Customer(customerName, customerPhone);

        System.out.print("Enter day: ");
        String day = scanner.nextLine();

        System.out.print("Enter movie title: ");
        String movieTitle = scanner.nextLine();

        System.out.print("Enter play time: ");
        String playTime = scanner.nextLine();

        Ticket ticket = cinema.bookTicket(day, movieTitle, playTime);
        if (ticket != null) {
            customer.addTicket(ticket);
            System.out.println("Ticket booked successfully.");
        } else {
            System.out.println("No tickets available.");
        }
    }

    private static void erasePlayTime(Scanner scanner, CinemaManagement cinema) {
        scanner.nextLine();
        System.out.print("Enter movie name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter play time: ");
        String playTime = scanner.nextLine();

        System.out.print("Enter day name: ");
        String dayName = scanner.nextLine();

        cinema.erasePlayTime(movieName, playTime, dayName);
        System.out.println("Play time erased successfully.");
    }

    private static void eraseMovie(Scanner scanner, CinemaManagement cinema) {
        scanner.nextLine();
        System.out.print("Enter movie name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter day name: ");
        String dayName = scanner.nextLine();

        cinema.eraseMovie(movieName, dayName);
        System.out.println("Movie erased successfully.");
    }

    private static void viewRoomForMovie(Scanner scanner, CinemaManagement cinema) {
        scanner.nextLine();
        System.out.print("Enter day: ");
        String dayName = scanner.nextLine();

        System.out.print("Enter movie name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter play time: ");
        String playTime = scanner.nextLine();

        cinema.viewMovieRoom(dayName, movieName, playTime);
    }
}
