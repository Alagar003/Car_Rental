package org.example.Payment;

import org.example.Payment.Payment;

public class CashPayment extends Payment {

    @Override
    public boolean processPayment(double amount) {
        // Simulate processing a cash payment
        System.out.println("Processing cash payment of $" + amount);
        paymentSuccessMessage(amount);
        return true;
    }
}
