package org.example.Payment;

public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    // Abstract method that must be implemented by all subclasses
    public abstract boolean processPayment();
}
