package org.example.Model;

public class Car {
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private double rentalPrice;

    public Car(String make, String model, int year, String licensePlate, double rentalPrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.rentalPrice = rentalPrice;
    }

    // Accessor methods
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    // Mutator methods
    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    // Display car information
    public void displayCarInfo() {
        System.out.println("Car: " + make + " " + model + " (" + year + ") | License Plate: " + licensePlate + " | Rental Price: $" + rentalPrice);
    }
}
