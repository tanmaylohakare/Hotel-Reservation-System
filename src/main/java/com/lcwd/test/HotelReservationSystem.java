package com.lcwd.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List <LocalDate> parseDates(String... dateString)
    {
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("ddMMMyyyy");
        List<LocalDate> dates =new ArrayList<>();

        for (String date : dateString)
        {
            dates.add(LocalDate.parse(date, formatter));
        }

        return dates;

    }

    public String findCheapestHotel(String ... dateString)
    {
        List<LocalDate> dates= parseDates(dateString);
        Hotel cheapesHotel = Collections.min(hotels, Comparator.comparing(hotels -> hotels.calculateTotalCost(dates)));
        int totalCost= cheapesHotel.calculateTotalCost(dates);

        return cheapesHotel.getName()+" , TotalRates $ ="+totalCost;
    }




}
