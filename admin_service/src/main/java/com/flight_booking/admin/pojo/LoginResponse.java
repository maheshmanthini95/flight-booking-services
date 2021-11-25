package com.flight_booking.admin.pojo;


public class LoginResponse {
    private Integer userId;
    private String userName;
    private String token;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer integer) {
        this.userId = integer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
