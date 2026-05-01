package com.hotel.booking.service;


import com.hotel.booking.model.RoomBooking;
import com.hotel.booking.repository.BookingRepository;
import com.hotel.common.enums.BookingStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public RoomBooking createBooking(RoomBooking booking){
        return bookingRepository.save(booking);
    }

    public RoomBooking cancelBooking(Long id){
        Optional<RoomBooking> optional = bookingRepository.findById(id);
        if (optional.isPresent()) {
            RoomBooking booking = optional.get();
            booking.setStatus(BookingStatus.CANCELLED);
            return bookingRepository.save(booking);
        }
        return null;
    }

    public RoomBooking checkIn(Long id){
        Optional<RoomBooking> optional = bookingRepository.findById(id);
        if(optional.isPresent()) {
            RoomBooking checkIn = optional.get();
            checkIn.setStatus(BookingStatus.CHECKED_IN);
            return bookingRepository.save(checkIn);
        }
        return null;
    }

    public RoomBooking checkOut(Long id){
        Optional<RoomBooking> optional = bookingRepository.findById(id);
        if(optional.isPresent()) {
            RoomBooking checkOut = optional.get();
            checkOut.setStatus(BookingStatus.CHECKED_OUT);
            return bookingRepository.save(checkOut);
        }
        return null;
    }



}
