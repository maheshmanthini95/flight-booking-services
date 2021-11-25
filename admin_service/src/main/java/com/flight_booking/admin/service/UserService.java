package com.flight_booking.admin.service;

import com.flight_booking.admin.entity.User;
import com.flight_booking.admin.pojo.LoginRequest;
import com.flight_booking.admin.pojo.LoginResponse;
import com.flight_booking.admin.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public LoginResponse validateAdminUserCredentials(LoginRequest loginRequest) {
        User user = userRepository.findByUserName(loginRequest.getUsername()).get();
        LoginResponse response = new LoginResponse();
        response.setUserId(user.getId());
        response.setUserName(user.getUserName());
        response.setToken("token");
        return response;
    }
}
