package com.hotel.housekeeping.repository;

import com.hotel.housekeeping.model.HouseKeeping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseKeepingRepository extends JpaRepository<HouseKeeping, Long> {
}
