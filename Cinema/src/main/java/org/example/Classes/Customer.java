package org.example.Classes;

import java.util.ArrayList;

public class Customer extends Person {
    private ArrayList<Ticket> bookedTickets;

    public Customer(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.bookedTickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        bookedTickets.add(ticket);
    }

    @Override
    public void displayDetails() {
        System.out.println("Customer Name: " + name + ", ID: " + phoneNumber);

        for ( Ticket ticket : bookedTickets ) {
            ticket.display();
        }
    }
}

