package com.flight_booking.user.pojo;

import javax.validation.constraints.NotBlank;

public class Passenger {
    @NotBlank
    private String passengerName;

    @NotBlank
    private Integer age;

    private Integer pnrNumber;

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

    public Integer getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(Integer pnrNumber) {
        this.pnrNumber = pnrNumber;
    }
}
