package com.flight_booking.admin.controller;

import com.flight_booking.admin.pojo.LoginRequest;
import com.flight_booking.admin.pojo.LoginResponse;
import com.flight_booking.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/v1.0/admin/login")
    ResponseEntity<?> adminLogin(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = userService.validateAdminUserCredentials(loginRequest);
        return ResponseEntity.ok(response);
    }
}