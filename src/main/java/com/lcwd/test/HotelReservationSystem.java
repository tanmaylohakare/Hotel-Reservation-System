package com.lcwd.test;

import java.time.DayOfWeek;
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

    public void addHotel(String name,int regularWeekdayRate,int regularWeekendRate,double rating)
    {
        Hotel hotel=new Hotel(name,regularWeekdayRate,regularWeekendRate, (int) rating);
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

    public String findCheapestHotelsWeekends(String...dataString)
    {
        List<LocalDate> dates =parseDates(dataString);

        List<LocalDate> weekendDates =dates.stream().
                filter(date -> {
                    DayOfWeek day =date.getDayOfWeek();

                    return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;}).collect(Collectors.toList());

        if (weekendDates.isEmpty())
        {
            return "No Weekends in given dates";
        }

        Hotel cheapestHotel= Collections.min(hotels,Comparator.comparing(hotel -> hotel.calculateTotalCost(weekendDates)));
        int totalCost= cheapestHotel.calculateTotalCost(weekendDates);

        return cheapestHotel.getName()+ ", Total WeeKend Rates $ ="+totalCost;
    }
    public String findCheapestBestRatedHotel(String... dateString) {
        List<LocalDate> dates = parseDates(dateString);

        Hotel cheapestBestRatedHotel = null;
        int minCost = Integer.MAX_VALUE;

        for (Hotel hotel : hotels) {
            int totalCost = hotel.calculateTotalCost(dates);

            // Check if the current hotel has the minimum cost or better rating at the same cost
            if (totalCost < minCost ||
                    (totalCost == minCost && (cheapestBestRatedHotel == null || hotel.getRating() > cheapestBestRatedHotel.getRating()))) {
                minCost = totalCost;
                cheapestBestRatedHotel = hotel;
            }
        }

        if (cheapestBestRatedHotel != null) {
            return cheapestBestRatedHotel.getName() +
                    ", Rating: " + cheapestBestRatedHotel.getRating() +
                    ", Total Rates: $" + minCost;
        } else {
            return "No hotels available for the given dates!";
        }
    }


}
