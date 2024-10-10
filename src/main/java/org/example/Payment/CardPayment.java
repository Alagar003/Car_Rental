package org.example.Payment;

public class CardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CardPayment(double amount, String cardNumber, String cardHolderName,
                       String expiryDate, String cvv) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }


    @Override
    public boolean processPayment() {
        if (validateCardDetails()) {
            System.out.println("Processing the Payment...");
            return true; // Assume payment was successful for this example
        } else {
            System.out.println("Card details are invalid.");
            return false;
        }
    }

    private boolean validateCardDetails() {
        // Basic validation for demonstration purposes
        return cardNumber.length() >= 1 && cvv.length() >=1  && !expiryDate.isEmpty();
    }
}
