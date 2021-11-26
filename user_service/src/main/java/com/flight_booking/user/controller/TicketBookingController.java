package com.flight_booking.user.controller;

import com.flight_booking.user.entity.Ticket;
import com.flight_booking.user.pojo.Flight;
import com.flight_booking.user.pojo.TicketBookingRequest;
import com.flight_booking.user.pojo.TicketBookingResponse;
import com.flight_booking.user.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class TicketBookingController {
    @Autowired
    TicketBookingService ticketBookingService;

    @Autowired
    RestTemplate restTemplate;

    @Value("${flight_booking.app.admin_service_url}")
    private String adminServiceURL;

    @PostMapping("/v1.0/flight/booking/{flightId}")
    public ResponseEntity<?> bookFlight(@PathVariable Integer flightId, @RequestBody TicketBookingRequest ticketBookingRequest) {
        TicketBookingResponse response = ticketBookingService.bookTickets(flightId, ticketBookingRequest);
        // Fetch the flight details from admin service.
        Flight flightDetails = restTemplate.getForEntity(adminServiceURL+"/v1.0/flight/"+response.getFlightId(), Flight.class).getBody();
        response.setAirline(flightDetails.getAirlineName());
        response.setArrivalTime(flightDetails.getArrivalTime());
        response.setDepartureTime(flightDetails.getDepartureTime());
        response.setFrom(flightDetails.getFrom());
        response.setTo(flightDetails.getTo());
        return ResponseEntity.ok(response);
    }
}
