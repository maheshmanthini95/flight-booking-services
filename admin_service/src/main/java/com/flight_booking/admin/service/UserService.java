package com.flight_booking.admin.service;

import com.flight_booking.admin.pojo.LoginRequest;
import com.flight_booking.admin.pojo.LoginResponse;
import com.flight_booking.admin.security.jwt.JwtUtils;
import com.flight_booking.admin.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    public LoginResponse validateAdminUserCredentials(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        LoginResponse  response = new LoginResponse();
        response.setUserId(userDetails.getId());
        response.setUserName(userDetails.getUsername());
        response.setToken(jwt);
        return response;
    }
}
