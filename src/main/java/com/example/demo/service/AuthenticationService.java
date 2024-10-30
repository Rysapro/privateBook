package com.example.demo.service;

import com.example.demo.domain.dto.SignInRequest;
import com.example.demo.domain.dto.SignUpRequest;
import com.example.demo.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    public JwtAuthenticationResponse signUp(SignUpRequest request);
    public JwtAuthenticationResponse signIn(SignInRequest request);
}
