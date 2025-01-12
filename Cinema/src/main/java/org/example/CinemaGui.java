package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.example.Classes.*;

public class CinemaGui {
    private JFrame frame;
    private JPanel daysPanel, moviesPanel;
    private JLabel moviesLabel;
    private Cinema cinema; // Instance of the Cinema class
    private List<JButton> dayButtons = new ArrayList<>(); // Store references to the day buttons

    public CinemaGui(Cinema cinema) {
        this.cinema = cinema; // Use the provided Cinema object
        createGUI();
    }

    private void createGUI() {
        // Load the background image
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\Rujoiu Cristina\\Pictures\\Cinema.jpg");
        Image bgImage = bgIcon.getImage();

        // Initialize the main frame
        frame = new JFrame("Cinema Schedule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Days panel (no background image here)
        daysPanel = new JPanel();
        daysPanel.setLayout(new GridLayout(1, 7));
        frame.add(daysPanel, BorderLayout.NORTH);

        // Movies panel with background image
        moviesPanel = new BackgroundPanel(bgImage);
        moviesPanel.setLayout(new BorderLayout());
        frame.add(moviesPanel, BorderLayout.CENTER);

        // Label to display movies
        moviesLabel = new JLabel("Select a day to view the movies", SwingConstants.RIGHT);
        moviesLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        moviesLabel.setForeground(Color.WHITE); // Change text color for visibility
        moviesPanel.add(moviesLabel, BorderLayout.CENTER);

        // Create buttons for each day of the week
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : days) {
            JButton dayButton = new JButton(day);
            dayButton.addActionListener(new DayButtonListener(day));
            dayButtons.add(dayButton);
            daysPanel.add(dayButton);
        }

        // Make the frame visible
        frame.setVisible(true);
    }

    // Listener for day buttons
    private class DayButtonListener implements ActionListener {
        private String dayName;

        public DayButtonListener(String dayName) {
            this.dayName = dayName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource(); // Identify which button was clicked

            for (JButton button : dayButtons) {
                button.setBackground(UIManager.getColor("Button.background")); // Reset to default
            }

            sourceButton.setBackground(Color.BLUE);

            moviesPanel.removeAll();

            for (Day day : cinema.getDays()) {
                if (day.getName().equalsIgnoreCase(dayName)) {
                    moviesPanel.setLayout(new BoxLayout(moviesPanel, BoxLayout.Y_AXIS));
                    moviesPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add padding around the panel

                    for (MovieSchedule schedule : day.getSchedules()) {
                       JPanel movieRow = new JPanel();
                        movieRow.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align components to the left
                        movieRow.setOpaque(false);
                        StringBuilder htmlContent = new StringBuilder("<html>");
                        htmlContent.append("<b>").append(schedule.getMovie().getTitle()).append("</b><br>");
                        htmlContent.append("<hr>");
                        String playTimes = String.join(", ", schedule.getPlayTime().keySet());
                        htmlContent.append(playTimes).append("</html>");

                        // Movie title and playtimes label
                        JLabel movieLabel = new JLabel(htmlContent.toString());
                        movieLabel.setFont(new Font("Arial", Font.PLAIN, 14));

                        // "Book" button
                        JButton bookButton = new JButton("Book");
                        bookButton.setPreferredSize(new Dimension(80, 30)); // Set button size
                        bookButton.setBackground(Color.GREEN); // Set button color
                        bookButton.setForeground(Color.WHITE); // Set button text color
//                        bookButton.addActionListener(new BookButtonListener(schedule, moviesPanel));

                        // Add components to the row
                        movieRow.add(bookButton); // Add the "Book" button first
                        movieRow.add(movieLabel); // Add the formatted movie label next

                        // Add the row to the movies panel
                        moviesPanel.add(movieRow);
                        moviesPanel.add(Box.createVerticalStrut(1));
                    }

                    moviesPanel.revalidate();
                    moviesPanel.repaint();
                    return;
                }
            }

            // If no movies are scheduled, show a message
            JLabel noMoviesLabel = new JLabel("No movies scheduled for " + dayName);
            noMoviesLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            moviesPanel.add(noMoviesLabel);

            moviesPanel.revalidate();
            moviesPanel.repaint();
        }



    }


public static void main(String[] args) {
        // Initialize cinema and populate data
        Cinema cinema = new Cinema();
        cinema.addRoom("Room A", 10, 10);
        cinema.addRoom("Room B", 15, 15);

        // Add movies to specific days
        Movie movie1 = new Movie("Inception", "Sci-Fi", 148);
        Movie movie2 = new Movie("Interstellar", "Sci-Fi", 169);
        Movie movie3 = new Movie("Avatar", "Sci-Fi", 169);
        Movie movie4 = new Movie("Moana", "Sci-Fi", 169);


        cinema.addMovieToDay(movie1, "Monday");
        cinema.addMovieToDay(movie2, "Monday");
        cinema.addMovieToDay(movie3, "Monday");
        cinema.addMovieToDay(movie4, "Monday");

        cinema.addMovieToDay(movie2, "Tuesday");

        cinema.addPlayTimeToDay("Inception", "10:00 AM", "Room A", "Monday");
        cinema.addPlayTimeToDay("Interstellar", "8:00 AM", "Room A", "Monday");

        cinema.addPlayTimeToDay("Inception", "12:00 AM", "Room A", "Monday");

        cinema.addPlayTimeToDay("Avatar", "12:00 AM", "Room A", "Monday");
        cinema.addPlayTimeToDay("Moana", "12:00 AM", "Room A", "Monday");


        cinema.addPlayTimeToDay("Interstellar", "02:00 PM", "Room B", "Tuesday");

        // Start the GUI
        new CinemaGui(cinema);
    }
}
