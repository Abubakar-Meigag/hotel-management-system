package com.hotel.room.service;

import com.hotel.common.enums.RoomStatus;
import com.hotel.room.model.Room;
import com.hotel.room.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room updateRoomStatus(Long id, RoomStatus status){
        Optional<Room> optional = roomRepository.findById(id);

        // Optional is a wrapper that handles the case where a value might or might not exist.
        if(optional.isPresent()){
            Room room = optional.get();
            room.setStatus(status);
            return roomRepository.save(room);
        }
        return null;
    }

}
