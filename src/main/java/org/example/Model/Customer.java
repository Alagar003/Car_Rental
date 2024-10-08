package org.example.Model;

public class Customer {
    private String name;
    private String city;
    private String licenseNumber;

    public Customer(String name, String city, String licenseNumber) {
        this.name = name;
        this.city = city;
        this.licenseNumber = licenseNumber;
    }

    // Accessor methods
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    // Display customer information
    public void displayCustomerInfo() {
        System.out.println("Customer: " + name + " | City: " + city + " | License: " + licenseNumber);
    }
}
