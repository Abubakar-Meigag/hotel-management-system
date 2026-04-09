# Hotel Management System

## Overview

A full-featured **Hotel Management System** built with Java following Object-Oriented Design principles. This system manages room bookings, guest check-ins/check-outs, housekeeping, billing, and automated notifications — designed as a microservices architecture.

---

## Business Description

The Hotel Management System is a digital platform that automates and streamlines the daily operations of a hotel. It replaces manual processes with an integrated, role-based system accessible by staff and guests.

### Core Capabilities

- **Room Management** — Track and manage rooms by type, availability, and status in real time
- **Booking Engine** — Allow guests and receptionists to search available rooms and create reservations
- **Check-in / Check-out** — Streamline the arrival and departure process with automated key assignment and room status updates
- **Housekeeping** — Log and monitor the cleaning and maintenance status of every room
- **Billing & Payments** — Generate detailed invoices and accept multiple payment methods
- **Notifications** — Automatically alert guests on booking confirmations, cancellations, and check-in reminders

---

## Room Types

| Type            | Description                              |
|-----------------|------------------------------------------|
| Standard        | Basic amenities, suitable for solo/couple |
| Deluxe          | Enhanced furnishings and services         |
| Family Suite    | Spacious rooms for families               |
| Business Suite  | Premium suite with business amenities     |

---

## System Actors

| Actor         | Responsibilities                                                              |
|---------------|-------------------------------------------------------------------------------|
| **Guest**     | Search available rooms, make and cancel bookings, pay bills                   |
| **Receptionist** | Add/modify rooms, create bookings, check in and check out customers        |
| **Manager**   | Add new workers, view reports, oversee operations                             |
| **Housekeeper** | Add and update housekeeping records for assigned rooms                      |
| **System**    | Send automated notifications for booking, cancellation, and check-in reminders |

---

## Key Business Workflows

### 1. Room Booking
1. Guest or Receptionist searches for available rooms by date and type
2. Available rooms are displayed with pricing
3. Guest selects a room and confirms the booking
4. System creates a booking record and sends a confirmation notification

### 2. Check-in
1. Guest arrives at the hotel
2. Receptionist verifies the booking
3. Receptionist assigns a room key
4. Room status is updated to **Occupied**

### 3. Check-out
1. Guest requests checkout
2. System generates invoice with all room charges
3. Guest pays via Credit Card, Check, or Cash
4. Room status is updated to **Available**
5. Housekeeping is notified for room preparation

### 4. Booking Cancellation
1. Guest or Receptionist initiates cancellation
2. System updates booking status to **Cancelled**
3. Room is released back to available inventory
4. Cancellation notification is sent to guest

### 5. Housekeeping
1. Housekeeper receives room assignment
2. Housekeeper performs cleaning/maintenance
3. Housekeeper logs the task in the system
4. Room status is updated accordingly

---

## Payment Methods

- Credit Card
- Check
- Cash

---

## Notifications

The system sends automated notifications for:
- Booking confirmation
- Booking cancellation
- Check-in reminder

---

## Technology Stack

| Layer              | Technology                    |
|--------------------|-------------------------------|
| Language           | Java 21                       |
| Architecture       | Microservices                 |
| Build Tool         | Maven / Gradle                |
| Database           | PostgreSQL (per service)      |
| Messaging          | RabbitMQ / Kafka              |
| API Gateway        | Spring Cloud Gateway          |
| Containerization   | Docker + Docker Compose       |

---

## Project Goals (Learning OOP in Java)

This project is designed to practise:
- **Encapsulation** — Room, Booking, Invoice classes hide internal data
- **Inheritance** — Guest, Receptionist, Manager extend Person/Account
- **Polymorphism** — Payment types (CreditCard, Cash, Check) implement a common interface
- **Abstraction** — Notification service abstracts delivery channels
- **Design Patterns** — Observer (notifications), Factory (room creation), Strategy (payment)

---

## Related Documents
- [Folder Structure](./FOLDER_STRUCTURE.md)
