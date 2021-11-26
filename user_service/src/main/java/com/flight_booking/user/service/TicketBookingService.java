package com.flight_booking.user.service;

import com.flight_booking.user.entity.Ticket;
import com.flight_booking.user.entity.TicketBooking;
import com.flight_booking.user.pojo.Passenger;
import com.flight_booking.user.pojo.TicketBookingRequest;
import com.flight_booking.user.pojo.TicketBookingResponse;
import com.flight_booking.user.repo.TicketBookingRepository;
import com.flight_booking.user.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TicketBookingService {

    @Autowired
    TicketBookingRepository ticketBookingRepository;

    @Autowired
    TicketRepository ticketRepository;

    /**
     * Method to create ticket booking and ticket entities.
     * @param flightId
     * @param request
     * @return
     */
    public TicketBookingResponse bookTickets(Integer flightId, TicketBookingRequest request) {
        TicketBooking ticketBooking = new TicketBooking();
        ticketBooking.setBookingEmail(request.getBookingEmail());
        ticketBooking.setBookingTime(new Date());
        ticketBooking.setFlightId(flightId);

        List<Passenger> passengers = request.getPassengers();
        List<Ticket> tickets = passengers.stream().map(p -> {
            Ticket ticket = new Ticket();
            ticket.setPassengerName(p.getPassengerName());
            ticket.setAge(p.getAge());

            Random rn = new Random();
            int range = 10000000 + 1;
            int pnr =  rn.nextInt(range) + 10000;
            ticket.setPnrNumber(pnr);
            ticket.setTicketBooking(ticketBooking);
            return ticket;
        }).collect(Collectors.toList());
        ticketBooking.setTickets(tickets);

        TicketBooking booking = ticketBookingRepository.save(ticketBooking);
        TicketBookingResponse response = new TicketBookingResponse();
        response.setBookingEmail(booking.getBookingEmail());
        response.setFlightId(booking.getFlightId());
        List<Passenger> passengers1 = booking.getTickets().stream().map(t-> {
            Passenger p = new Passenger();
            p.setPassengerName(t.getPassengerName());
            p.setAge(t.getAge());
            p.setPnrNumber(t.getPnrNumber());
            return p;
        }).collect(Collectors.toList());
        response.setPassengers(passengers1);
        return response;
    }
}
