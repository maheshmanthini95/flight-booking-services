package com.flight_booking.user.repo;

import com.flight_booking.user.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
   Optional<Ticket> findByPnrNumber(Integer pnrNumber);
}
