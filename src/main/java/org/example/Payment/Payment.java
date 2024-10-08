package org.example.Payment;

public abstract class Payment {

    // Abstract method to process a payment
    public abstract boolean processPayment(double amount);

    // Common method for all payment methods (optional)
    public void paymentSuccessMessage(double amount) {
        System.out.println("Payment of $" + amount + " was successful.");
    }
}
