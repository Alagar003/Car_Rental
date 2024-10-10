package org.example.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private String customerName;
    private String licensePlate;
    private Date startDate;
    private Date endDate;
    private double price;
    private double totalAmount;

    public Reservation(String customerName, String licensePlate, Date startDate, Date endDate, double price) {
        this.customerName = customerName;
        this.licensePlate = licensePlate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public double getPrice() {
        return price;
    }
    public double getTotalAmount() {
        return totalAmount;
    }

    public String getFormattedStartDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(startDate);
    }

    public String getFormattedEndDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(endDate);
    }

    private double calculateTotalAmount() {
        long durationInMillis = endDate.getTime() - startDate.getTime();
        long durationInDays = TimeUnit.DAYS.convert(durationInMillis, TimeUnit.MILLISECONDS); // Calculate duration in days

        // Ensure the duration is at least 1 day
        if (durationInDays < 1) {
            durationInDays = 1;
        }

        return price * durationInDays;
    }



}
