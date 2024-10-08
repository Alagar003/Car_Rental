package org.example.Payment;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public boolean processPayment(double amount) {
        // Simulate processing a credit card payment
        System.out.println("Processing credit card payment of $" + amount);
        paymentSuccessMessage(amount);
        return true;
    }
}
