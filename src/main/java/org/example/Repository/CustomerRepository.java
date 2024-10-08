package org.example.Repository;


import org.example.Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>(); // Start with an empty list
    }

    // Method to get all customers
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // Method to add a customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Method to find a customer by name
    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null; // Customer not found
    }
}
