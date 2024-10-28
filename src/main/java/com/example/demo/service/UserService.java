package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    void save (User user);
    void create (User user);
    User getByUsername (String username);
    User getCurrentUser();
    void getAdmin ();

    UserDetailsService userDetailsService();
}
