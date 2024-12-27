package com.lcwd.test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        System.out.println("WelCome To Hotel Management System : ");

        HotelReservationSystem reservationSystem=new HotelReservationSystem();

        reservationSystem.addHotel("Lakewood",110,90,4.2);
        reservationSystem.addHotel("Bridgewood", 160,60,3.8);
        reservationSystem.addHotel("Ridgewood",220,150,4.0);

        reservationSystem.displayHotels();

        String cheapestWeekdayHotel = reservationSystem.findCheapestHotel("10Sep2020","11Sep2020");
        System.out.println("Cheapest Hotel Week Days"+ cheapestWeekdayHotel);

        String cheapestWeekendsHotel = reservationSystem.findCheapestHotelsWeekends("30Nov2024","01Jan2020");
        System.out.println("Cheapest Hotel "+ cheapestWeekendsHotel);
     }

}
