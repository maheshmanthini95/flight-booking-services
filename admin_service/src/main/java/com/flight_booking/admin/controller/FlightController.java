package com.flight_booking.admin.controller;

import com.flight_booking.admin.pojo.FlightSearchQuery;
import com.flight_booking.admin.pojo.FlightSearchResponse;
import com.flight_booking.admin.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {
    @Autowired
    FlightService flightService;

    /**
     * Api handler to return all the available flights.
     * @param query
     * @return
     */
    @PostMapping("/v1.0/flight/search")
    public ResponseEntity<?> getFlights(@RequestBody FlightSearchQuery query) {
       List<FlightSearchResponse> flights = flightService.findAll();
       return ResponseEntity.ok(flights);
    }

    @GetMapping("/v1.0/flight/{id}")
    public ResponseEntity<?> getFlightById(@PathVariable Integer id) {
        FlightSearchResponse response = flightService.getFlightDetails(id);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id.");
        }
        return ResponseEntity.ok(response);
    }
}
