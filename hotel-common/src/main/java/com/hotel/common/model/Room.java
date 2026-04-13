package com.hotel.common.model;
import com.hotel.common.enums.RoomStatus;
import com.hotel.common.enums.RoomStyle;

import java.math.BigDecimal;

public class Room {

    private int roomNumber;
    private RoomStyle style;
    private RoomStatus status;
    private BigDecimal price;
    private RoomKey roomKey;

    // room constructor
    public Room(int roomNumber, RoomStyle style, RoomStatus status, BigDecimal price,  RoomKey roomKey) {
        this.roomNumber = roomNumber;
        this.style = style;
        this.status = status;
        this.price = price;
        this.roomKey = roomKey;
    };

    public RoomKey getRoomKey() {
        return roomKey;
    }

    public void setRoomKey(RoomKey roomKey) {
        this.roomKey = roomKey;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public RoomStyle getStyle() {
        return style;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setStyle(RoomStyle style) {
        this.style = style;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}