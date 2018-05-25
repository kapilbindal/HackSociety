package com.example.kapil.hackteam.models;

/**
 * Created by KAPIL on 26-05-2018.
 */

public class Summary {
    public String addedFrom;
    public String addTime;
    public String addDate;
    public int addAmount;

    public Summary(){};

    public Summary(String addedFrom, String addTime, String addDate, int addAmount) {
        this.addedFrom = addedFrom;
        this.addTime = addTime;
        this.addDate = addDate;
        this.addAmount = addAmount;
    }

    public String getAddedFrom() {
        return addedFrom;
    }

    public String getAddTime() {
        return addTime;
    }

    public String getAddDate() {
        return addDate;
    }

    public int getAddAmount() {
        return addAmount;
    }

    public void setAddedFrom(String addedFrom) {
        this.addedFrom = addedFrom;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public void setAddAmount(int addAmount) {
        this.addAmount = addAmount;
    }
}
