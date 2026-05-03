# Hotel Management System — Implementation Guide

Complete each phase before moving to the next.

---

## Phase 1 — Project Setup

**Goal:** Get the multi-module project structure ready.

1. Create a new Maven or Gradle project
2. Add these modules: `hotel-common`, `hotel-room-service`, `hotel-booking-service`, `hotel-guest-service`, `hotel-housekeeping-service`, `hotel-billing-service`, `hotel-notification-service`, `hotel-api-gateway`
3. Add Spring Boot, Lombok, JPA, and PostgreSQL dependencies to each module
4. Give each service its own `application.yml` with a unique port
5. Confirm every module compiles cleanly before continuing

---

## Phase 2 — Core Domain Models

**Goal:** Create the main Java classes that represent hotel entities.

1. Create a `Hotel` class with name, address, and a list of rooms
2. Create a `Room` class with room number, style, status, price, and an assigned key
3. Create a `RoomKey` class linked to a room
4. Create a `RoomBooking` class that links a guest to a room with check-in and check-out dates and a booking status
5. Create a `RoomHouseKeeping` class that tracks who is cleaning which room and the current status
6. Create an `Invoice` class with a list of charges and a total amount
7. Create a `RoomCharge` class representing any extra service a guest requested
8. Define all necessary enums: `RoomStyle`, `RoomStatus`, `BookingStatus`, `HouseKeepingStatus`

---

## Phase 3 — People and Accounts

**Goal:** Model all the users of the system using inheritance.

1. Create an abstract `Person` class with name, email, and phone
2. Create an abstract `Account` class that extends `Person` and adds login credentials and account status
3. Create `Guest`, `Receptionist`, `Manager`, and `Housekeeper` classes that each extend `Account`
4. Add role-specific fields to each class (for example, a guest has a list of bookings)

---

## Phase 4 — Payment System

**Goal:** Support multiple payment methods using a shared interface.

1. Create a `Payment` interface with a method to process a payment and return the payment type
2. Implement `CreditCardPayment`, `CashPayment`, and `CheckPayment` as separate classes that each implement the interface
3. Each implementation should handle its own processing logic independently

---

## Phase 5 — Notification System

**Goal:** Automatically send alerts when booking events happen.

1. Create a `NotificationSender` interface with a method to send a message to a recipient
2. Implement `EmailNotification` and `SMSNotification` as separate classes
3. Create a `NotificationService` that listens for booking events and triggers the right notification
4. Handle three events: booking confirmed, booking cancelled, check-in reminder

---

## Phase 6 — Service Layer

**Goal:** Write the business logic that ties everything together.

1. Create a `RoomService` with methods to add a room, update room status, and search available rooms
2. Create a `BookingService` with methods to create a booking, cancel a booking, check in, and check out
3. Create a `GuestService` with methods to register a guest and find a guest by id 
4. Create a `HouseKeepingService` with methods to assign a housekeeper and update task status 
5. Create a `BillingService` with methods to generate an invoice and process a payment 
6. Wire services together where needed (for example, checking out triggers billing and housekeeping)

---

## Phase 7 — REST API and Testing

**Goal:** Expose the services via REST endpoints and verify everything works.

1. Create a REST controller for each service
2. Expose endpoints for: searching rooms, creating and cancelling bookings, check-in, check-out, housekeeping updates, generating invoices, and processing payments
3. Set up the API Gateway to route requests to the correct service
4. Write unit tests for each service class using JUnit 5 and Mockito
5. Write integration tests for each controller
6. Test all three payment types
7. Test that notifications fire correctly on each booking event

---

## Summary

| Phase | What You Build              | OOP Concept               |
|-------|-----------------------------|---------------------------|
| 1     | Project structure           | Architecture and modules  |
| 2     | Domain classes and enums    | Encapsulation             |
| 3     | Users and accounts          | Inheritance               |
| 4     | Payment methods             | Polymorphism              |
| 5     | Notifications               | Interfaces, Observer      |
| 6     | Business logic              | Single Responsibility     |
| 7     | API and tests               | Integration               |
