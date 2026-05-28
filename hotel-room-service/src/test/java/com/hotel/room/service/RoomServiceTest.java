package com.hotel.room.service;

import com.hotel.common.enums.RoomStatus;
import com.hotel.common.enums.RoomStyle;
import com.hotel.room.model.Room;
import com.hotel.room.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    @Test
    void shouldSaveRoomWhenAddRoomIsCalled() {

        Room room = new Room(101, RoomStyle.DELUXE, RoomStatus.AVAILABLE, new BigDecimal("149.99"));

        when(roomRepository.save(room)).thenReturn(room);

        Room result = roomService.addRoom(room);
        assertEquals(room, result);
    }

    @Test
    void shouldGetAllRoomsWhenGetAllRoomsIsCalled() {

        Room room = new Room(102, RoomStyle.STANDARD, RoomStatus.AVAILABLE, new BigDecimal("109.49"));

        when(roomRepository.findAll()).thenReturn(List.of(room));

        List<Room> result = roomService.getAllRooms();
        assertEquals(List.of(room), result);
    }

    @Test
    void shouldUpdateRoomWhenUpdateRoomIsCalled() {

        Room room = new Room(102, RoomStyle.FAMILY_SUITE, RoomStatus.AVAILABLE, new BigDecimal("449.99"));

        when(roomRepository.findById(3L)).thenReturn(Optional.of(room));
        when(roomRepository.save(room)).thenReturn(room);

        Room result = roomService.updateRoomStatus(3L, RoomStatus.OCCUPIED);
        assertEquals(room, result);
    }

}