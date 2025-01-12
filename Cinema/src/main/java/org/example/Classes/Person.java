package org.example.Classes;

abstract class Person {
    protected String name;
    protected String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public abstract void displayDetails();
}
