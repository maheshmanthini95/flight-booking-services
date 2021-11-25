package com.flight_booking.admin.service;

import com.flight_booking.admin.entity.Airline;
import com.flight_booking.admin.repo.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {
    @Autowired
    AirlineRepository airlineRepository;

    public Airline saveAirline(Airline airline) {
        Airline a = airlineRepository.save(airline);
        return a;
    }
}
