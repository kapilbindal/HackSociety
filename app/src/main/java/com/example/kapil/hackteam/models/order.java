package com.example.kapil.hackteam.models;

/**
 * Created by KAPIL on 25-05-2018.
 */

public class Order {
    public String orderNumber;
    public String payTime;
    public String payDate;
    public String payDetails;
    public int payAmount;

    public Order (){}

    public Order(String orderNumber, String payTime, String payDate, String payDetails, int payAmount) {
        this.orderNumber = orderNumber;
        this.payTime = payTime;
        this.payDate = payDate;
        this.payDetails = payDetails;
        this.payAmount = payAmount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getPayTime() {
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

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setPayTime(String payTime) {
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
