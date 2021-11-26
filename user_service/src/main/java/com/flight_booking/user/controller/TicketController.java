package com.flight_booking.user.controller;

import com.flight_booking.user.entity.Ticket;
import com.flight_booking.user.pojo.Flight;
import com.flight_booking.user.pojo.TicketResponse;
import com.flight_booking.user.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    RestTemplate restTemplate;

    @Value("${flight_booking.app.admin_service_url}")
    private String adminServiceURL;

    @GetMapping("/v1.0/flight/ticket/{pnr}")
    public ResponseEntity<?> getTicketDetails(@PathVariable Integer pnr) {
        TicketResponse ticketResponse = ticketService.getTicketDetails(pnr);

        // Fetch the flight details from admin service.
        Flight flightDetails = restTemplate.getForEntity(adminServiceURL+"/v1.0/flight/"+ticketResponse.getFlight().getFlightId(), Flight.class).getBody();
        ticketResponse.setFlight(flightDetails);
        return ResponseEntity.ok(ticketResponse);
    }
}
