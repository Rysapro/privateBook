package com.example.demo.domain.dto;

public record BookDTO(
        int id,
        String title,
        String authorName,
        String authorSurname,
        int authorAge,
        String authorCountry,
        int cost
) {}
