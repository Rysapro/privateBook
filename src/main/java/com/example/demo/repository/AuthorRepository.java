package com.example.demo.repository;

import com.example.demo.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findByNameAndSurname(String name, String surname);
}