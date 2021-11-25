package com.flight_booking.admin.entity;

import javax.persistence.Entity;

@Entity
public class Airline extends BaseEntity {
    private String airlineName;

    private Boolean isDisabled = false;

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Boolean getDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean disabled) {
        isDisabled = disabled;
    }
}