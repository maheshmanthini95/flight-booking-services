package com.flight_booking.user.controller;

import com.flight_booking.user.pojo.TicketBookingRequest;
import com.flight_booking.user.pojo.TicketBookingResponse;
import com.flight_booking.user.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TicketBookingController {
    @Autowired
    TicketBookingService ticketBookingService;

    @PostMapping("/v1.0/flight/booking/{flightId}")
    public ResponseEntity<?> bookFlight(@PathVariable Integer flightId, @RequestBody TicketBookingRequest ticketBookingRequest) {
        TicketBookingResponse response = ticketBookingService.bookTickets(flightId, ticketBookingRequest);
        return ResponseEntity.ok(response);
    }
}
