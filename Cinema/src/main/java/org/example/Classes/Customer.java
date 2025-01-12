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
        System.out.println("Customer Name: " + name + ", phone: " + phoneNumber);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public ArrayList<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    @Override
    public String getPhone() {
        return this.phoneNumber;
    }
}

