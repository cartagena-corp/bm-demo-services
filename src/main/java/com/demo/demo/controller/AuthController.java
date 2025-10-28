package com.demo.demo.controller;

import com.demo.demo.service.AuthService;
import com.demo.demo.service.dto.JwtResponse;
import com.demo.demo.service.dto.LoginRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequestDto loginRequestDto) {
        JwtResponse jwtResponse = authService.userLogin(loginRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jwtResponse);
    }
}
