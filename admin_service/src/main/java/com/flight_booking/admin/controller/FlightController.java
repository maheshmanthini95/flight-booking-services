package com.flight_booking.admin.controller;

import com.flight_booking.admin.pojo.FlightSearchQuery;
import com.flight_booking.admin.pojo.FlightSearchResponse;
import com.flight_booking.admin.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
