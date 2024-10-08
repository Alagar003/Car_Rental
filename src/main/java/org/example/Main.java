package org.example;

import org.example.Repository.CarRepository;
import org.example.Repository.CustomerRepository;
import org.example.Repository.ReservationRepository;
import org.example.Model.Car;
import org.example.Model.Customer;
import org.example.Model.Reservation;
import org.example.Services.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
                CarRepository carRepository = new CarRepository();
                CustomerRepository customerRepository = new CustomerRepository();
                ReservationRepository reservationRepository = new ReservationRepository();
                ReservationService reservationService = new ReservationService(reservationRepository);

                // Creating sample cars and customers in main
                carRepository.addCar(new Car("Toyota", "Camry", 2020, "ABC123", 50.0));
                carRepository.addCar(new Car("Honda", "Accord", 2019, "XYZ456", 55.0));
                carRepository.addCar(new Car("Ford", "Focus", 2021, "DEF789", 45.0));

                customerRepository.addCustomer(new Customer("Alice Smith", "New York", "NY12345"));
                customerRepository.addCustomer(new Customer("Bob Johnson", "Los Angeles", "CA67890"));

                Scanner scanner = new Scanner(System.in);
                int userOpt = 1;

                while (userOpt == 1) {
                        System.out.println("Available Cars:");
                        for (Car car : carRepository.getAllCars()) {
                                System.out.println("Car: " + car.getMake() + " " + car.getModel() + " (" + car.getYear() + ") | License Plate: " + car.getLicensePlate() + " | Rental Price: $" + car.getRentalPrice());
                        }

                        System.out.println("Enter 1 to rent a car, or 2 to exit");
                        userOpt = scanner.nextInt();

                        if (userOpt == 1) {
                                System.out.println("Enter your name:");
                                String customerName = scanner.next();
                                Customer customer = customerRepository.getCustomerByName(customerName);

                                // Check if customer is not found and prompt registration
                                if (customer == null) {
                                        System.out.println("Customer not found. Please register.");
                                        System.out.println("Enter your name:");
                                        String newName = scanner.next();
                                        System.out.println("Enter your city:");
                                        String newCity = scanner.next();
                                        System.out.println("Enter your license number:");
                                        String newLicenseNumber = scanner.next();

                                        // Register the new customer
                                        customer = new Customer(newName, newCity, newLicenseNumber);
                                        customerRepository.addCustomer(customer);
                                        System.out.println("Registration successful!");
                                }

                                System.out.println("Enter license plate of the car you want to rent:");
                                String licensePlate = scanner.next();
                                System.out.println("Enter start date (dd-MM-yyyy):");
                                String startDateInput = scanner.next();
                                System.out.println("Enter end date (dd-MM-yyyy):");
                                String endDateInput = scanner.next();

                                // Parse the dates
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                try {
                                        Date startDate = dateFormat.parse(startDateInput);
                                        Date endDate = dateFormat.parse(endDateInput);

                                        // Check availability
                                        if (reservationService.isCarAvailable(licensePlate, startDate, endDate)) {
                                                // Create a new reservation
                                                Reservation reservation = new Reservation(customer.getName(), licensePlate, startDate, endDate);
                                                reservationService.addReservation(reservation);
                                                System.out.println("Your reservation is confirmed.");
                                        } else {
                                                System.out.println("Sorry, the car is not available for the selected dates.");
                                        }
                                } catch (ParseException e) {
                                        System.out.println("Invalid date format. Please use dd-MM-yyyy.");
                                }
                        }
                }

                scanner.close();
        }
}
