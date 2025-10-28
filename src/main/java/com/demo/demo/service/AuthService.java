package com.demo.demo.service;

import com.demo.demo.service.dto.JwtResponse;
import com.demo.demo.service.dto.LoginRequestDto;

public interface AuthService {
    JwtResponse userLogin(LoginRequestDto loginRequestDto);
}
