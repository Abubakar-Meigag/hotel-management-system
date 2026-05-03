package com.hotel.guest.controller;


import com.hotel.guest.model.Guest;
import com.hotel.guest.service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {


    private GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable Long id){
        return guestService.getGuestById(id);
    }

    @PostMapping
    public Guest reqisterNewGuest(@RequestBody Guest guest){
        return guestService.registerGuest(guest);
    }
}
