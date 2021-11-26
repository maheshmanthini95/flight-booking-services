package com.flight_booking.admin.repo;

import com.flight_booking.admin.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
    Optional<Airline> findById(Integer id);
}
