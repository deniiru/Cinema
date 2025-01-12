package org.example.Classes;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Customers {
    private static final String DATA_FILE = "C:/Users/Rujoiu Cristina/Desktop/Cinema/Cinema/date.txt";
    private ArrayList<Customer> customers;

    public Customers() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        if (!findCustomer(customer.getName(), customer.getPhone())) {
            customers.add(customer);
        }
    }

    public void displayAllCustomerNames() {
        System.out.println("Lista clienților:");
        for (Customer customer : customers) {
            customer.displayDetails();
        }
    }

    public void displayTicketsForCustomer(String customerName) {
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                System.out.println("Biletele pentru clientul " + customerName + ":");
                for (Ticket ticket : customer.getBookedTickets()) {
                    ticket.display();
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Clientul cu numele " + customerName + " nu a fost găsit.");
        }
    }



    public void saveToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Create Gson instance with pretty printing
        try (FileWriter writer = new FileWriter(DATA_FILE)) {
            gson.toJson(this, writer);
            System.out.println("information saved");
        } catch (IOException e) {
            System.err.println("Failed to save cinema information: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(DATA_FILE)) {
            Customers loadCustomers = gson.fromJson(reader, Customers.class);

            // Update the current object's fields
            this.customers = loadCustomers.customers;
            System.out.println("Information loaded successfully");
        } catch (IOException e) {
            System.err.println("Failed to load cinema information: " + e.getMessage());
        }
    }

    public boolean findCustomer(String customerName, String phone) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName) && customer.getPhone().equalsIgnoreCase(phone)) {
                return true;
            }
        }
        return false;
    }
}