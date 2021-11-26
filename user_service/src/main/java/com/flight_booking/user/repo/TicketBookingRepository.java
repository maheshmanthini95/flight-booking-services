package com.flight_booking.user.repo;

import com.flight_booking.user.entity.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer> {
   Optional<TicketBooking> findById(Integer id);
}
