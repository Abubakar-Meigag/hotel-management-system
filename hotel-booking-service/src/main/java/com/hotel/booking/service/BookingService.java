package com.hotel.booking.service;


import com.hotel.booking.event.CancelledEventPublisher;
import com.hotel.booking.event.CheckoutEventPublisher;
import com.hotel.booking.event.ConfirmedEventPublisher;
import com.hotel.booking.model.RoomBooking;
import com.hotel.booking.repository.BookingRepository;
import com.hotel.common.enums.BookingStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private CheckoutEventPublisher checkoutEventPublisher;
    private ConfirmedEventPublisher confirmedEventPublisher;
    private CancelledEventPublisher cancelledEventPublisher;

    public BookingService(BookingRepository bookingRepository, CheckoutEventPublisher checkoutEventPublisher, ConfirmedEventPublisher confirmedEventPublisher, CancelledEventPublisher cancelledEventPublisher){
        this.bookingRepository = bookingRepository;
        this.checkoutEventPublisher = checkoutEventPublisher;
        this.confirmedEventPublisher = confirmedEventPublisher;
        this.cancelledEventPublisher = cancelledEventPublisher;
    }

    public RoomBooking createBooking(RoomBooking booking){
        RoomBooking saved = bookingRepository.save(booking);
        confirmedEventPublisher.publishConfirmedEvent(saved.getId());
        return saved;
    }

    public RoomBooking cancelBooking(Long id){
        Optional<RoomBooking> optional = bookingRepository.findById(id);
        if (optional.isPresent()) {
            RoomBooking booking = optional.get();
            booking.setStatus(BookingStatus.CANCELLED);
            RoomBooking saved = bookingRepository.save(booking);
            cancelledEventPublisher.publishCancelledEvent(id);

            return saved;
        }
        return null;
    }

    public RoomBooking checkIn(Long id){
        Optional<RoomBooking> optional = bookingRepository.findById(id);
        if(optional.isPresent()) {
            RoomBooking checkIn = optional.get();
            checkIn.setStatus(BookingStatus.CHECKED_IN);
            RoomBooking saved = bookingRepository.save(checkIn);
            confirmedEventPublisher.publishConfirmedEvent(id);

            return saved;
        }
        return null;
    }

    public RoomBooking checkOut(Long id){
        Optional<RoomBooking> optional = bookingRepository.findById(id);
        if(optional.isPresent()) {
            RoomBooking checkOut = optional.get();
            checkOut.setStatus(BookingStatus.CHECKED_OUT);
            RoomBooking saved = bookingRepository.save(checkOut);
            checkoutEventPublisher.publishCheckoutEvent(id);

            return saved;
        }
        return null;
    }
}
