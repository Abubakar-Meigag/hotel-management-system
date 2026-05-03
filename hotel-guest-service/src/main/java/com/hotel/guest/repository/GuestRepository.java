package com.hotel.guest.repository;

import com.hotel.guest.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {}
