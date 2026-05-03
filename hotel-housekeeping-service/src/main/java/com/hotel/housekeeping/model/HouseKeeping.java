package com.hotel.housekeeping.model;


import com.hotel.common.enums.HouseKeepingStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "houseKeeping")
public class HouseKeeping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long roomId;
    private Long houseKeeperId;
    @Enumerated(EnumType.STRING)
    private HouseKeepingStatus status;
    private LocalDate startDate;
    private String notes;

    public HouseKeeping(Long id, Long roomId, Long houseKeeperId, HouseKeepingStatus status, LocalDate startDate, String notes) {
        this.id = id;
        this.roomId = roomId;
        this.houseKeeperId = houseKeeperId;
        this.status = status;
        this.startDate = startDate;
        this.notes = notes;
    }

    public HouseKeeping() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getHouseKeeperId() {
        return houseKeeperId;
    }

    public void setHouseKeeperId(Long houseKeeperId) {
        this.houseKeeperId = houseKeeperId;
    }

    public HouseKeepingStatus getStatus() {
        return status;
    }

    public void setStatus(HouseKeepingStatus status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
