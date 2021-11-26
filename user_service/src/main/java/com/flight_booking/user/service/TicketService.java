package com.flight_booking.user.service;

import com.flight_booking.user.entity.Ticket;
import com.flight_booking.user.pojo.Flight;
import com.flight_booking.user.pojo.TicketResponse;
import com.flight_booking.user.repo.TicketBookingRepository;
import com.flight_booking.user.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketBookingRepository ticketBookingRepository;

    public TicketResponse getTicketDetails(Integer pnr) {
        Ticket ticket = ticketRepository.findByPnrNumber(pnr).get();

        TicketResponse response = new TicketResponse();
        response.setTicketId(ticket.getId());
        response.setPassengerName(ticket.getPassengerName());
        response.setAge(ticket.getAge());
        response.setPnrNumber(pnr);

        Flight flight = new Flight();
        flight.setFlightId(ticket.getTicketBooking().getFlightId());

        response.setFlight(flight);

        return response;
    }
}
