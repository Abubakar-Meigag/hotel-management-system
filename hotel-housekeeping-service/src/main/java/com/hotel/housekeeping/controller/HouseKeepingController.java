package com.hotel.housekeeping.controller;


import com.hotel.common.enums.HouseKeepingStatus;
import com.hotel.housekeeping.model.HouseKeeping;
import com.hotel.housekeeping.service.HouseKeepingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/housekeeping")
public class HouseKeepingController {


    private HouseKeepingService houseKeepingService;

    public HouseKeepingController(HouseKeepingService houseKeepingService) {
        this.houseKeepingService = houseKeepingService;
    }

    @PostMapping
    public HouseKeeping assignHouseKeepingTask(@RequestBody HouseKeeping houseKeeping){
        return houseKeepingService.assignHousKeeping(houseKeeping);
    }

    @PutMapping("/{id}/status")
    public HouseKeeping updateTaskStatus(@PathVariable Long id, @RequestParam HouseKeepingStatus status){
        return houseKeepingService.updateStatus(id, status);
    }
}
