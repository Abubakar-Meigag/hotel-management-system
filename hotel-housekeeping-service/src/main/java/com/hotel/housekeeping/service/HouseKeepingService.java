package com.hotel.housekeeping.service;



import com.hotel.common.enums.HouseKeepingStatus;
import com.hotel.housekeeping.model.HouseKeeping;
import com.hotel.housekeeping.repository.HouseKeepingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseKeepingService {

    private HouseKeepingRepository houseKeepingRepository;

    public HouseKeepingService(HouseKeepingRepository houseKeepingRepository) {
        this.houseKeepingRepository = houseKeepingRepository;
    }

    public HouseKeeping assignHousKeeping(HouseKeeping houseKeeping){
        return houseKeepingRepository.save(houseKeeping);
    }

    public HouseKeeping updateStatus(Long id, HouseKeepingStatus status){
        Optional<HouseKeeping> optional = houseKeepingRepository.findById(id);

        if(optional.isPresent()){
            HouseKeeping task = optional.get();
            task.setStatus(status);
            return houseKeepingRepository.save(task);
        }
        return null;
    }
}
