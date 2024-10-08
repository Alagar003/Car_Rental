package org.example.Services;


import org.example.Model.Car;
import org.example.Repository.CarRepository;

import java.util.ArrayList;

public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Get all cars
    public ArrayList<Car> getAllCars() {
        return (ArrayList<Car>) carRepository.getAllCars();
    }

    // Get a car by license plate
    public Car getCarByLicensePlate(String licensePlate) {
        for (Car car : carRepository.getAllCars()) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null; // If car not found
    }

    // Add a new car
    public void addCar(Car car) {
        carRepository.getAllCars().add(car);
    }

    // Display all cars
    public void displayCars() {
        for (Car car : carRepository.getAllCars()) {
            car.displayCarInfo();
        }
    }
}
