package com.lcwd.test;

public class Hotel {

    private String name;
    private int regularWeekDayRate;
    private int regularWeekendRate;

    public Hotel(String name, int regularWeekDayRate, int regularWeekendRate) {
        this.name = name;
        this.regularWeekDayRate = regularWeekDayRate;
        this.regularWeekendRate = regularWeekendRate;
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

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", regularWeekDayRate=" + regularWeekDayRate +
                ", regularWeekendRate=" + regularWeekendRate +
                '}';
    }
}
