package com.example.kapil.hackteam.models;

/**
 * Created by KAPIL on 25-05-2018.
 */

public class Order {
    public int orderNumber;
    public double payTime;
    public String payDate;
    public String payDetails;
    public int payAmount;

    public Order (){}

    public Order(int orderNumber, double payTime, String payDate, String payDetails, int payAmount) {
        this.orderNumber = orderNumber;
        this.payTime = payTime;
        this.payDate = payDate;
        this.payDetails = payDetails;
        this.payAmount = payAmount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public double getPayTime() {
        return payTime;
    }

    public String getPayDate() {
        return payDate;
    }

    public String getPayDetails() {
        return payDetails;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setPayTime(double payTime) {
        this.payTime = payTime;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public void setPayDetails(String payDetails) {
        this.payDetails = payDetails;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }
}
