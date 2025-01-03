package com.lcwd.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Hotel {

    private String name;
    private int regularWeekDayRate;
    private int regularWeekendRate;
    private double rating;
    private int RewardInWeekdays;
    private int RewardInWeekends;

    public Hotel(String name, int regularWeekDayRate, int regularWeekendRate,double rating,int RewardInWeekdays,int RewardInWeekends) {
        this.name = name;
        this.regularWeekDayRate = regularWeekDayRate;
        this.regularWeekendRate = regularWeekendRate;
        this.rating=rating;
        this.RewardInWeekdays=RewardInWeekdays;
        this.RewardInWeekends=RewardInWeekends;
    }

    public Hotel(String name, int regularWeekdayRate, int regularWeekendRate, int rating) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegularWeekDayRate() {
        return regularWeekDayRate;
    }

    public void setRegularWeekDayRate(int regularWeekDayRate) {
        this.regularWeekDayRate = regularWeekDayRate;
    }

    public int getRegularWeekendRate() {
        return regularWeekendRate;
    }

    public void setRegularWeekendRate(int regularWeekendRate) {
        this.regularWeekendRate = regularWeekendRate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRewardInWeekdays()
    {
        return RewardInWeekdays;
    }

    public void setRewardInWeekdays(int rewardInWeekdays) {
        RewardInWeekdays = rewardInWeekdays;
    }

    public int getRewardInWeekends() {
        return RewardInWeekends;
    }

    public void setRewardInWeekends(int rewardInWeekends) {
        RewardInWeekends = rewardInWeekends;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
               ", regularWeekDayRate=" + regularWeekDayRate +
                ", regularWeekendRate=" + regularWeekendRate +
                ", rating" + rating +
                ", RewardInWeekdays" +RewardInWeekdays+
                ", RewardInWeekends"+RewardInWeekends+
                '}';
    }

    public int calculateTotalCost(List<LocalDate> dates)
    {       int totalCost =0;

        for(LocalDate date : dates)
        {
            DayOfWeek day= date.getDayOfWeek();
            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)
            {
                totalCost += regularWeekendRate;
            }
            else {
                totalCost += RewardInWeekdays;
            }
        }
        return  totalCost;
    }
}