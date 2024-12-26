package com.lcwd.test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        System.out.println("WelCome To Hotel Management System : ");

        HotelReservationSystem reservationSystem=new HotelReservationSystem();

        reservationSystem.addHotel("Lakewood",110,90);
        reservationSystem.addHotel("Bridgewood", 160,60);
        reservationSystem.addHotel("Ridgewood",220,150);

        reservationSystem.displayHotels();
     }

}
