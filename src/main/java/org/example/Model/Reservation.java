package org.example.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private String customerName;
    private String licensePlate;
    private Date startDate;
    private Date endDate;

    public Reservation(String customerName, String licensePlate, Date startDate, Date endDate) {
        this.customerName = customerName;
        this.licensePlate = licensePlate;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getFormattedStartDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(startDate);
    }

    public String getFormattedEndDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(endDate);
    }
}
