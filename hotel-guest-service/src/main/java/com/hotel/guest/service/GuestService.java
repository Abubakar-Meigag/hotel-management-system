package com.hotel.guest.service;


import com.hotel.guest.model.Guest;
import com.hotel.guest.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestService {

    private GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Guest registerGuest(Guest guest){
        return guestRepository.save(guest);
    }

    public Guest getGuestById(Long id){
        Optional<Guest> optional = guestRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
