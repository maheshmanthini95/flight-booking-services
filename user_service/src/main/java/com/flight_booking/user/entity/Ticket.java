package com.flight_booking.user.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ticket extends BaseEntity {
    @ManyToOne
    private TicketBooking ticketBooking;

    private Integer pnrNumber;

    private String passengerName;

    private Integer age;

    private Boolean isCancelled;

    public TicketBooking getTicketBooking() {
        return ticketBooking;
    }

    public void setTicketBooking(TicketBooking ticketBooking) {
        this.ticketBooking = ticketBooking;
    }

    public Integer getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(Integer pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getCancelled() {
        return isCancelled;
    }

    public void setCancelled(Boolean cancelled) {
        isCancelled = cancelled;
    }
}
