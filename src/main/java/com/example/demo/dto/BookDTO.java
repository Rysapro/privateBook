package com.example.demo.dto;

public record BookDTO(
        int id,
        String title,
        String authorName,
        String authorSurname,
        int authorAge,
        String authorCountry,
        int cost
) {}
