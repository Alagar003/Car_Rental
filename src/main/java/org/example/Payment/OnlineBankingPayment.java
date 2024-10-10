package org.example.Payment;

public class OnlineBankingPayment extends Payment {
    private String bankAccountNumber;
    private String bankName;

    public OnlineBankingPayment(double amount, String bankAccountNumber, String bankName) {
        super(amount);
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
    }

    @Override
    public boolean processPayment() {
        if (validateBankDetails()) {
            System.out.println("Processing the Payment");
            return true;
        } else {
            System.out.println("Bank account details are invalid.");
            return false;
        }
    }

    private boolean validateBankDetails() {
        return bankAccountNumber.length() >= 1 && !bankName.isEmpty();
    }
}
