package com.example.demo.dto;

import com.example.demo.Author;

public record BookDTO(
        int id,
        String title,
        String authorName,
        String authorSurname,
        int authorAge,
        String authorCountry,
        int cost
) {}
