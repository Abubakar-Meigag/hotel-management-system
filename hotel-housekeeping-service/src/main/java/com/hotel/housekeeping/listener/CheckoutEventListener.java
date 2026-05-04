package com.hotel.housekeeping.listener;


import com.hotel.common.config.RabbitMQConfig;
import com.hotel.common.enums.HouseKeepingStatus;
import com.hotel.housekeeping.model.HouseKeeping;
import com.hotel.housekeeping.service.HouseKeepingService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CheckoutEventListener {

    private HouseKeepingService houseKeepingService;

    public CheckoutEventListener(HouseKeepingService houseKeepingService) {
        this.houseKeepingService = houseKeepingService;
    }

    @RabbitListener(queues = RabbitMQConfig.CHECKOUT_QUEUE)
    public void handleCheckout(Long bookingId) {
        HouseKeeping task = new HouseKeeping();
        task.setRoomId(bookingId);
        task.setStatus(HouseKeepingStatus.PENDING);
        task.setNotes("Room cleaning required after checkout");
        houseKeepingService.assignHousKeeping(task);
    }
}

