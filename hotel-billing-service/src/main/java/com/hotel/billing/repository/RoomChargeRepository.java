package com.hotel.billing.repository;

import com.hotel.billing.model.RoomCharge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomChargeRepository extends JpaRepository<RoomCharge, Long> {
}
