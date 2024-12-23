package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName (String toke);
    String generateToken (UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);

}
