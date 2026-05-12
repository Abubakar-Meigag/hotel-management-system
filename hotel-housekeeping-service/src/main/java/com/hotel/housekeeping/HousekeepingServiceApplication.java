package com.hotel.housekeeping;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.hotel.housekeeping", "com.hotel.common"})
@EnableRabbit
public class HousekeepingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HousekeepingServiceApplication.class, args);
    }
}
