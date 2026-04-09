package com.hotel.common.model;

import java.math.BigDecimal;
import java.util.List;

public class Hotel {

    private String hotelName;
    private String hotelAddress;
    private List<Room> rooms;

    // hotel constructor
    public Hotel(String hotelName, String hotelAddress, List<Room> rooms){}

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}