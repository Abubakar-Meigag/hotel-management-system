package com.hotel.common.model;
import java.math.BigDecimal;

public class Room {

    private int roomNumber;
    private String style;
    private String status;
    private BigDecimal price;
    private RoomKey roomKey;

    // room constructor
    public Room(int roomNumber, String style, String status, BigDecimal price,  RoomKey roomKey) {
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

    public String getStyle() {
        return style;
    }

    public String getStatus() {
        return status;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}