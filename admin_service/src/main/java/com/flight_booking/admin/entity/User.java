package com.flight_booking.admin.entity;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
    private String userName;

    private String pwdHash;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash;
    }
}
