package com.hotel.common.model;

import com.hotel.common.enums.HouseKeepingStatus;

import java.time.LocalDate;

public class RoomHouseKeeping {

    private Housekeeper houseKeeperName;
    private LocalDate startDate;
    private LocalDate endDate;
    private HouseKeepingStatus status;
    private String notes;
    private Room room;

    public RoomHouseKeeping(Housekeeper houseKeeperName, LocalDate startDate, LocalDate endDate, HouseKeepingStatus status, String notes, Room room) {
        this.houseKeeperName = houseKeeperName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.notes = notes;
        this.room = room;
    }

    public Housekeeper getHouseKeeperName() {
        return houseKeeperName;
    }

    public void setHouseKeeperName(Housekeeper houseKeeperName) {
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

    public HouseKeepingStatus getStatus() {
        return status;
    }

    public void setStatus(HouseKeepingStatus status) {
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
