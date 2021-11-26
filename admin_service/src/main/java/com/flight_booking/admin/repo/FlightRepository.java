package com.flight_booking.admin.repo;

import com.flight_booking.admin.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findById(Integer id);
}
