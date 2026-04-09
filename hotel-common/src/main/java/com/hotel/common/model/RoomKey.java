package com.hotel.common.model;

public class RoomKey {

    private Room room;
    private String keyCode;

    // room key constructor
    public RoomKey(Room room, String keyCode) {
        this.room = room;
        this.keyCode = keyCode;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
