package com.lcwd.test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        System.out.println("WelCome To Hotel Management System : ");

        HotelReservationSystem reservationSystem=new HotelReservationSystem();

        reservationSystem.addHotel("Lakewood",110,90,4.5,80,80);
        reservationSystem.addHotel("Bridgewood", 160,60,5,80,80);
        reservationSystem.addHotel("Ridgewood",220,150,5,100,40);

        reservationSystem.displayHotels();

//        String cheapestWeekdayHotel = reservationSystem.findCheapestHotel("10Sep2020","11Sep2020");
//        System.out.println("Cheapest Hotel Week Days"+ cheapestWeekdayHotel);
//
//        String cheapestWeekendsHotel = reservationSystem.findCheapestHotelsWeekends("11Sep2020","12Sep2020");
//        System.out.println("Cheapest Hotel "+ cheapestWeekendsHotel);
//
//        String bestRatedHotel = reservationSystem.findCheapestBestRatedHotel("11Sep2020","12Sep2020");
//        System.out.println("Cheapest Best-Rated Hotel: " + bestRatedHotel);


        String result = reservationSystem.findCheapestBestRatedHotelForRewardCustomer(
                "Reward", "11Sep2020", "12Sep2020");
        System.out.println(result);


    }
}
