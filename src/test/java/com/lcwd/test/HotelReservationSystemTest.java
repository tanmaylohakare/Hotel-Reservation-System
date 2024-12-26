package com.lcwd.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelReservationSystemTest {

    @Test
    public void testAddHotel()
    {
        HotelReservationSystem reservationSystem=new HotelReservationSystem();

        //add Hotel
        reservationSystem.addHotel("Lakewood",110,90);
        reservationSystem.addHotel("Bridgwood",160,60);


        //to check hotel countn add
        assertEquals(2, reservationSystem.hotels.size());
        assertEquals("Lakewood",reservationSystem.hotels.get(0).getName());
        assertEquals(110,reservationSystem.hotels.get(0).getRegularWeekDayRate());

    }

}
