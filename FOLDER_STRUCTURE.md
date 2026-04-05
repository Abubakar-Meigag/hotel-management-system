# Hotel Management System — Folder Structure

```
hotel-management-system/
│
├── hotel-common/                          # Shared code across all services
│   └── src/main/java/com/hotel/common/
│       ├── enums/
│       │   ├── RoomStyle.java             # STANDARD, DELUXE, FAMILY_SUITE, BUSINESS_SUITE
│       │   ├── RoomStatus.java            # AVAILABLE, OCCUPIED, MAINTENANCE
│       │   ├── BookingStatus.java         # CONFIRMED, CANCELLED, CHECKED_IN, CHECKED_OUT
│       │   ├── HouseKeepingStatus.java    # PENDING, IN_PROGRESS, DONE
│       │   └── AccountStatus.java         # ACTIVE, BLOCKED
│       ├── interfaces/
│       │   ├── Payment.java               # Payment interface
│       │   └── NotificationSender.java    # Notification interface
│       └── dto/
│           ├── BookingRequest.java
│           ├── BookingResponse.java
│           └── PaymentRequest.java
│
├── hotel-room-service/                    # Room management microservice
│   └── src/
│       ├── main/java/com/hotel/room/
│       │   ├── model/
│       │   │   ├── Room.java
│       │   │   └── RoomKey.java
│       │   ├── repository/
│       │   │   └── RoomRepository.java
│       │   ├── service/
│       │   │   └── RoomService.java
│       │   └── controller/
│       │       └── RoomController.java
│       └── resources/
│           └── application.yml
│
├── hotel-booking-service/                 # Booking and reservation microservice
│   └── src/
│       ├── main/java/com/hotel/booking/
│       │   ├── model/
│       │   │   └── RoomBooking.java
│       │   ├── repository/
│       │   │   └── BookingRepository.java
│       │   ├── service/
│       │   │   └── BookingService.java
│       │   └── controller/
│       │       └── BookingController.java
│       └── resources/
│           └── application.yml
│
├── hotel-guest-service/                   # Guest and account microservice
│   └── src/
│       ├── main/java/com/hotel/guest/
│       │   ├── model/
│       │   │   ├── Person.java            # Abstract base
│       │   │   ├── Account.java           # Abstract, extends Person
│       │   │   ├── Guest.java
│       │   │   ├── Receptionist.java
│       │   │   ├── Manager.java
│       │   │   └── Housekeeper.java
│       │   ├── repository/
│       │   │   └── GuestRepository.java
│       │   ├── service/
│       │   │   └── GuestService.java
│       │   └── controller/
│       │       └── GuestController.java
│       └── resources/
│           └── application.yml
│
├── hotel-housekeeping-service/            # Housekeeping logs microservice
│   └── src/
│       ├── main/java/com/hotel/housekeeping/
│       │   ├── model/
│       │   │   └── RoomHouseKeeping.java
│       │   ├── repository/
│       │   │   └── HouseKeepingRepository.java
│       │   ├── service/
│       │   │   └── HouseKeepingService.java
│       │   └── controller/
│       │       └── HouseKeepingController.java
│       └── resources/
│           └── application.yml
│
├── hotel-billing-service/                 # Invoice and payment microservice
│   └── src/
│       ├── main/java/com/hotel/billing/
│       │   ├── model/
│       │   │   ├── Invoice.java
│       │   │   ├── InvoiceItem.java
│       │   │   └── RoomCharge.java
│       │   ├── payment/
│       │   │   ├── CreditCardPayment.java
│       │   │   ├── CashPayment.java
│       │   │   └── CheckPayment.java
│       │   ├── service/
│       │   │   └── BillingService.java
│       │   └── controller/
│       │       └── BillingController.java
│       └── resources/
│           └── application.yml
│
├── hotel-notification-service/            # Notification microservice
│   └── src/
│       ├── main/java/com/hotel/notification/
│       │   ├── model/
│       │   │   └── Notification.java
│       │   ├── sender/
│       │   │   ├── EmailNotification.java
│       │   │   └── SMSNotification.java
│       │   ├── service/
│       │   │   └── NotificationService.java
│       │   └── listener/
│       │       └── BookingEventListener.java
│       └── resources/
│           └── application.yml
│
├── hotel-api-gateway/                     # Single entry point for all services
│   └── src/
│       ├── main/java/com/hotel/gateway/
│       │   └── GatewayApplication.java
│       └── resources/
│           └── application.yml            # Route configuration
│
├── docker-compose.yml                     # Run all services together
├── pom.xml                                # Root Maven POM
└── README.md
```

---

## Notes

- Each service has its own `application.yml` and runs on a different port
- `hotel-common` is a shared library (not a deployable service)
- All services communicate via REST or a message broker (RabbitMQ/Kafka)
- `hotel-api-gateway` routes external requests to the correct service
