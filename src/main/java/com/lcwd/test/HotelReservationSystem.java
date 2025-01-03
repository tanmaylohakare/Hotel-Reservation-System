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


    // Add Hotel Method
    public void addHotel(String name,int regularWeekdayRate,int regularWeekendRate,double rating,int rewardWeekdayRate, int rewardWeekendRate)
    {
        Hotel hotel=new Hotel(name,regularWeekdayRate,regularWeekendRate, (int) rating, rewardWeekdayRate, rewardWeekendRate );
        hotels.add(hotel);

    }

    // display Hotel
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


    // Find Cheapest Rate Hotel
    public String findCheapestHotel(String ... dateString)
    {
        List<LocalDate> dates= parseDates(dateString);
        Hotel cheapesHotel = Collections.min(hotels, Comparator.comparing(hotels -> hotels.calculateTotalCost(dates)));
        int totalCost= cheapesHotel.calculateTotalCost(dates);

        return cheapesHotel.getName()+" , TotalRates $ ="+totalCost;
    }

    // Find Cheapest Hotels At WeekEnd
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

//find Cheapest with best rate
    public String findCheapestBestRatedHotel(String... dateString) {
        List<LocalDate> dates = parseDates(dateString);

        Hotel bestRatedHotel = Collections.max(hotels, Comparator.comparing(Hotel::getRating));

        if (bestRatedHotel != null) {
            int totalCost = bestRatedHotel.calculateTotalCost(dates);
            return bestRatedHotel.getName() +
                    ", Rating: " + bestRatedHotel.getRating() +
                    ", Total Rates: $" + totalCost;
        }  else {
            return "No hotels available for the given dates!";
        }
    }


    public String findCheapestBestRatedHotelForRewardCustomer(String customerType, String... dateString) {
        // Validate Customer Type
        if (!customerType.equalsIgnoreCase("Reward")) {
            return "Invalid customer type. Only 'Reward' customers are supported.";
        }

        // Parse Dates
        List<LocalDate> dates = parseDates(dateString);
        if (dates.isEmpty()) {
            return "Invalid date format. Please use 'ddMMMyyyy'.";
        }

        Hotel cheapestHotel = null;
        int lowestCost = Integer.MAX_VALUE;

        // Find the cheapest best-rated hotel
        for (Hotel hotel : hotels) {
            int cost = hotel.calculateTotalCost(dates);

            if (cost < lowestCost || (cost == lowestCost && hotel.getRating() > (cheapestHotel != null ? cheapestHotel.getRating() : 0))) {
                lowestCost = cost;
                cheapestHotel = hotel;
            }
        }

        if (cheapestHotel == null) {
            return "No hotels available for the given dates.";
        }

        return cheapestHotel.getName() +
                ", Rating: " + cheapestHotel.getRating() +
                ", Total Rates: $" + lowestCost;
    }
 }
