package org.example.Repository;


import org.example.Model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private List<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>(); // Start with an empty list
    }

    // Method to get all cars
    public List<Car> getAllCars() {
        return cars;
    }

    // Method to add a car
    public void addCar(Car car) {
        cars.add(car);
    }
}
