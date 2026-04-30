package com.hotel.room.model;

import com.hotel.common.enums.RoomStatus;
import com.hotel.common.enums.RoomStyle;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int roomNumber;
    @Enumerated(EnumType.STRING)
    private RoomStyle style;
    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    private BigDecimal price;

    public Room(int roomNumber, RoomStyle style, RoomStatus status, BigDecimal price) {
        this.roomNumber = roomNumber;
        this.style = style;
        this.status = status;
        this.price = price;
    }

    // JPA requires a no-argument constructor like this Room() constructor
    public Room() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomStyle getStyle() {
        return style;
    }

    public void setStyle(RoomStyle style) {
        this.style = style;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
