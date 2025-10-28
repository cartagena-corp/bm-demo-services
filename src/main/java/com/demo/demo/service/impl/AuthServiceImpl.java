package com.demo.demo.service.impl;

import com.demo.demo.security.CustomUserDetails;
import com.demo.demo.security.CustomUserDetailsService;
import com.demo.demo.security.JwtUtil;
import com.demo.demo.service.AuthService;
import com.demo.demo.service.dto.JwtResponse;
import com.demo.demo.service.dto.LoginRequestDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           CustomUserDetailsService userDetailsService,
                           JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public JwtResponse userLogin(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUser(),
                        loginRequestDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDto.getUser());
        CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
        String token = jwtUtil.generateToken(userDetails, customUserDetails.getName());

        return new JwtResponse(token, "Bearer");
    }
}
