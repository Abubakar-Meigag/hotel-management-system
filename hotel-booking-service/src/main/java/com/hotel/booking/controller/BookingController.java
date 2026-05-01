package com.hotel.booking.controller;

import com.hotel.booking.model.RoomBooking;
import com.hotel.booking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 the rule is:
  @PathVariable → only simple types like Long, String, int — things that fit in a URL
  @RequestBody → complex objects like RoomBooking — comes from the request body as JSON

  So when you need to identify which resource to act on you use @PathVariable with an id.
  When you need to send full data you use @RequestBody with an object.
*/

@RestController
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping
    public RoomBooking createNewBooking(@RequestBody RoomBooking booking){
        return bookingService.createBooking(booking);
    }

    @PutMapping("/{id}/cancel")
    public RoomBooking cancelBooking(@PathVariable Long id){
        return bookingService.cancelBooking(id);
    }

    @PutMapping("/{id}/checkin")
    public RoomBooking checkIn(@PathVariable Long id){
        return bookingService.checkIn(id);
    }

    @PutMapping("/{id}/checkout")
    public RoomBooking checkout(@PathVariable Long id){
        return bookingService.checkOut(id);
    }
}
