package org.example;
import org.example.Payment.CardPayment;
import org.example.Payment.OnlineBankingPayment;
import org.example.DAL.CarRepository;
import org.example.DAL.CustomerRepository;
import org.example.DAL.ReservationRepository;
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
                customerRepository.addCustomer(new Customer("Ram", "Bangalore", "CA67890"));

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
                                                Car selectedCar = CarRepository.getCarByLicensePlate(licensePlate); // Get the selected car
                                                double rentalPrice = selectedCar.getRentalPrice(); // Get the rental price from the selected car

                                                // Create a new reservation with the rental price
                                                Reservation reservation = new Reservation(customer.getName(), licensePlate, startDate, endDate, rentalPrice);
                                                reservationService.addReservation(reservation);
                                                System.out.println("Your reservation is confirmed.");
                                                System.out.println("Total Amount: $" + reservation.getTotalAmount()); // Display total amount

                                                // Payment Process
                                                System.out.println("Choose a payment method: ");
                                                System.out.println("1. Card Payment");
                                                System.out.println("2. Online Banking Payment");
                                                int paymentChoice = scanner.nextInt();

                                                if (paymentChoice == 1) {
                                                        // Process Card Payment
                                                        System.out.println("Enter card number:");
                                                        String cardNumber = scanner.next();
                                                        System.out.println("Enter card holder name:");
                                                        String cardHolderName = scanner.next();
                                                        System.out.println("Enter expiry date (MM/YY):");
                                                        String expiryDate = scanner.next();
                                                        System.out.println("Enter CVV:");
                                                        String cvv = scanner.next();

                                                        CardPayment cardPayment = new CardPayment(reservation.getTotalAmount(), cardNumber, cardHolderName, expiryDate, cvv);
                                                        boolean paymentStatus = cardPayment.processPayment();
                                                        if (paymentStatus) {
                                                                System.out.println("Payment successful!");
                                                        } else {
                                                                System.out.println("Payment failed!");
                                                        }
                                                } else if (paymentChoice == 2) {
                                                        // Process Online Banking Payment
                                                        System.out.println("Enter your bank account number:");
                                                        String bankAccountNumber = scanner.next();
                                                        System.out.println("Enter your bank name:");
                                                        String bankName = scanner.next();

                                                        OnlineBankingPayment bankPayment = new OnlineBankingPayment(reservation.getTotalAmount(),bankAccountNumber, bankName);
                                                        boolean paymentStatus = bankPayment.processPayment();
                                                        if (paymentStatus) {
                                                                System.out.println("Payment successful!");
                                                        } else {
                                                                System.out.println("Payment failed!");
                                                        }
                                                } else {
                                                        System.out.println("Invalid payment method selected.");
                                                }

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
