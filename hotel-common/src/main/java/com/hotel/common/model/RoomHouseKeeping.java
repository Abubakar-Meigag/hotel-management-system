package com.hotel.common.model;

import java.time.LocalDate;

public class RoomHouseKeeping {

    private String houseKeeperName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String notes;
    private Room room;

    public RoomHouseKeeping(String houseKeeperName, LocalDate startDate, LocalDate endDate, String status, String notes, Room room) {
        this.houseKeeperName = houseKeeperName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.notes = notes;
        this.room = room;
    }

    public String getHouseKeeperName() {
        return houseKeeperName;
    }

    public void setHouseKeeperName(String houseKeeperName) {
        this.houseKeeperName = houseKeeperName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
