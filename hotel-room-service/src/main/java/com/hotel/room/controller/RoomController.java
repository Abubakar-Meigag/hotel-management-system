package com.hotel.room.controller;


import com.hotel.common.enums.RoomStatus;
import com.hotel.room.model.Room;
import com.hotel.room.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @PutMapping("/{id}/status")
    public Room updateRoom(@PathVariable Long id, @RequestParam RoomStatus status){
        return roomService.updateRoomStatus(id, status);
    }


}
