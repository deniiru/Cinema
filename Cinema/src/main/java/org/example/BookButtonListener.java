//package org.example;
//
//import org.example.Classes.MovieSchedule;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//class BookButtonListener implements ActionListener {
//    private MovieSchedule schedule;
//    JPanel moviesPanel ;
//
//    public BookButtonListener(MovieSchedule schedule, JPanel moviesPanel) {
//        this.schedule = schedule;
//        this.moviesPanel = moviesPanel;
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // Clear the moviesPanel to display booking layout
//        moviesPanel.removeAll();
//        moviesPanel.setLayout(new BorderLayout()); // Use BorderLayout for the main layout
//
//        // Top Panel: Back button and Movie title
//        JPanel topPanel = new JPanel(new BorderLayout());
//        JButton backButton = new JButton("Back");
//        backButton.setPreferredSize(new Dimension(80, 30));
//        backButton.addActionListener(event -> resetMoviesPanel()); // Reset to movie list when pressed
//        JLabel movieTitleLabel = new JLabel(schedule.getMovie().getTitle(), SwingConstants.RIGHT);
//        movieTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        topPanel.add(backButton, BorderLayout.WEST);
//        topPanel.add(movieTitleLabel, BorderLayout.EAST);
//
//        // Middle Panel: Form inputs and seat visualization
//        JPanel middlePanel = new JPanel();
//        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
//
//        // Enter Person Name
//        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        JLabel nameLabel = new JLabel("Enter person name:");
//        JTextField nameField = new JTextField(20); // Input field for name
//        namePanel.add(nameLabel);
//        namePanel.add(nameField);
//
////        // Choose Seats
////        JPanel seatsPanel = new JPanel();
//////        seatsPanel.setLayout(new GridLayout(room.getRows(), room.getCols(), 5, 5)); // Create a grid for seats
//////        seatsPanel.setBorder(BorderFactory.createTitledBorder("Choose Seats"));
//////        for (int i = 0; i < room.getRows(); i++) {
//////            for (int j = 0; j < room.getCols(); j++) {
//////                JButton seatButton = new JButton();
//////                seatButton.setBackground(room.isSeatAvailable(i, j) ? Color.GREEN : Color.RED); // Green for available, Red for booked
//////                seatButton.setPreferredSize(new Dimension(40, 40)); // Adjust seat button size
//////                int row = i, col = j; // Capture the row and col for booking logic
//////                seatButton.addActionListener(event -> toggleSeatSelection(room, row, col, seatButton));
//////                seatsPanel.add(seatButton);
//////            }
//////        }
////
////        middlePanel.add(namePanel);
////        middlePanel.add(seatsPanel);
////
////        // Bottom Panel: Price and Send button
////        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
////        JLabel priceLabel = new JLabel("Price:");
////        JButton sendButton = new JButton("SEND");
////        sendButton.setPreferredSize(new Dimension(80, 30));
////        sendButton.addActionListener(event -> finalizeBooking(nameField.getText(), room)); // Booking logic
////
////        bottomPanel.add(priceLabel);
////        bottomPanel.add(sendButton);
//
//        // Add panels to the moviesPanel
//        moviesPanel.add(topPanel, BorderLayout.NORTH);
////        moviesPanel.add(middlePanel, BorderLayout.CENTER);
////        moviesPanel.add(bottomPanel, BorderLayout.SOUTH);
//
//        // Repaint and revalidate to apply changes
//        moviesPanel.revalidate();
//        moviesPanel.repaint();
//    }
//
//    // Helper function to reset the panel back to the movie list
//    private void resetMoviesPanel() {
//        moviesPanel.removeAll();
//        displayMoviesList(); // Function to redisplay the list of movies
//        moviesPanel.revalidate();
//        moviesPanel.repaint();
//    }
//
//    // Helper function to toggle seat selection
//    private void toggleSeatSelection(Room room, int row, int col, JButton seatButton) {
//        if (room.isSeatAvailable(row, col)) {
//            room.bookSeat(row, col); // Book the seat
//            seatButton.setBackground(Color.RED);
//        } else {
//            room.cancelSeatBooking(row, col); // Cancel the booking
//            seatButton.setBackground(Color.GREEN);
//        }
//    }
//
//    // Helper function to finalize the booking
//    private void finalizeBooking(String personName, Room room) {
//        if (personName.isEmpty()) {
//            JOptionPane.showMessageDialog(frame, "Please enter a name!", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        JOptionPane.showMessageDialog(frame, "Booking completed for " + personName, "Success", JOptionPane.INFORMATION_MESSAGE);
//    }
//
//}
