package com.hotel.booking.repository;

import com.hotel.booking.model.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<RoomBooking, Long> {}
