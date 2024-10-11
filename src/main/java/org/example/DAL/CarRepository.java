package org.example.DAL;
import org.example.Model.Car;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private static List<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    // Method to get all cars
    public List<Car> getAllCars() {
        return cars;
    }

    // Method to add a car
    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public static Car getCarByLicensePlate(String licensePlate) {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null;
    }

}
