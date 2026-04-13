package com.hotel.common.model;

import com.hotel.common.enums.BookingStatus;

import java.time.LocalDate;

public class RoomBooking {

    private String bookingId;
    private Room room;
    private Guest guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BookingStatus status;

    // room booking constructor
    public RoomBooking(String bookingId, Room room, Guest guestName, LocalDate checkInDate, LocalDate checkOutDate, BookingStatus status) {
        this.bookingId = bookingId;
        this.room = room;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuestName() {
        return guestName;
    }

    public void setGuestName(Guest guestName) {
        this.guestName = guestName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
