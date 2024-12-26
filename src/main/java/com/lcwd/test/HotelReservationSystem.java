package com.lcwd.test;

import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {

    public List<Hotel> hotels;

    public HotelReservationSystem()
    {
        hotels=new ArrayList<>();
    }

    public void addHotel(String name,int regularWeekdayRate,int regularWeekendRate)
    {
        Hotel hotel=new Hotel(name,regularWeekdayRate,regularWeekendRate);
        hotels.add(hotel);

    }

    public void displayHotels()
    {
        if(hotels.isEmpty())
        {
            System.out.println("No hotel available");
        }
        else
        {
            System.out.println("List of Hotels :");
            for (Hotel hotel : hotels)
            {
                System.out.println(hotel);
            }
        }
    }



}
