package com.flight_booking.admin.service;

import com.flight_booking.admin.entity.Flight;
import com.flight_booking.admin.pojo.FlightSearchQuery;
import com.flight_booking.admin.pojo.FlightSearchResponse;
import com.flight_booking.admin.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    /**
     * Method to return flights based on search criteria.
     * @param query
     * @return
     */
    public List<Flight> getFlights(FlightSearchQuery query) {
        List<Flight> flights = new ArrayList<>();

        if (query.getId() != null) {
           Flight flight = flightRepository.findById(query.getId()).get();
           if (flight != null) {
               flights.add(flight);
           }
        } else if (query.getArrivalTime() != null && query.getDepartureTime() != null) {

        }
        return null;
    }

    /**
     * Method to return all the flights.
     * @return
     */
    public List<FlightSearchResponse> findAll() {
        List<Flight> flights = flightRepository.findAll();
        List<FlightSearchResponse> result = flights.stream().map((Flight flight) -> {
            FlightSearchResponse search = new FlightSearchResponse();
            search.setFlightId(flight.getId());
            search.setFlightNumber(flight.getFlightNumber());
            search.setAirlineId(flight.getAirline().getId());
            search.setAirlineName(flight.getAirline().getAirlineName());
            search.setFrom(flight.getFrom().getCity());
            search.setTo(flight.getTo().getCity());

            // Set arrival time and departure time.
            Integer arrivalTime = flight.getArrivalTime();
            Integer departureTime = flight.getDepartureTime();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Hmm");
            LocalTime aTime = LocalTime.parse(arrivalTime+"", formatter);
            LocalTime dTime = LocalTime.parse(departureTime+"", formatter);

            search.setArrivalTime(aTime.toString());
            search.setDepartureTime(dTime.toString());

            return search;
        }).collect(Collectors.toList());

        return result;
    }

    /**
     * Method to get complete flight details by id.
     * @param flightId
     * @return
     */
    public FlightSearchResponse getFlightDetails(Integer flightId) {
        Flight flight = flightRepository.findById(flightId).get();

        if (flight == null) {
            return null;
        }
        FlightSearchResponse response = new FlightSearchResponse();
        response.setFlightId(flight.getId());
        response.setFlightNumber(flight.getFlightNumber());
        response.setAirlineId(flight.getAirline().getId());
        response.setAirlineName(flight.getAirline().getAirlineName());
        response.setFrom(flight.getFrom().getCity());
        response.setTo(flight.getTo().getCity());

        Integer arrivalTime = flight.getArrivalTime();
        Integer departureTime = flight.getDepartureTime();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Hmm");
        LocalTime aTime = LocalTime.parse(arrivalTime+"", formatter);
        LocalTime dTime = LocalTime.parse(departureTime+"", formatter);
        response.setDepartureTime(dTime.toString());
        response.setArrivalTime(aTime.toString());

        return response;
    }
}
