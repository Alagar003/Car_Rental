package org.example.Services;
import org.example.Model.Customer;
import org.example.DAL.CustomerRepository;

import java.util.ArrayList;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Get all customers
    public ArrayList<Customer> getAllCustomers() {
        return (ArrayList<Customer>) customerRepository.getAllCustomers();
    }

    // Get a customer by name (case-insensitive and trimmed)
    public Customer getCustomerByName(String name) {
        name = name.trim().toLowerCase(); // Trim and convert input to lowercase for case-insensitive comparison

        for (Customer customer : customerRepository.getAllCustomers()) {
            if (customer.getName().toLowerCase().equals(name)) {
                return customer;
            }
        }
        return null; // If customer not found
    }

    // Add a new customer
    public void addCustomer(Customer customer) {
        customerRepository.getAllCustomers().add(customer);
    }

    // Display all customers
    public void displayCustomers() {
        for (Customer customer : customerRepository.getAllCustomers()) {
            customer.displayCustomerInfo();
        }
    }
}
