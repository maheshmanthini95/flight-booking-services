package com.flight_booking.admin.controller;

import com.flight_booking.admin.entity.Airline;
import com.flight_booking.admin.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AirlineController {
    @Autowired
    AirlineService airlineService;

    @PostMapping("/v1.0/airlines")
    public ResponseEntity saveAirline(@RequestBody Airline airline) {
        Airline response = airlineService.saveAirline(airline);
        return ResponseEntity.ok(response);
    }
}
