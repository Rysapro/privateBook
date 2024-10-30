package com.example.demo.service;

import com.example.demo.domain.dto.AuthorDTO;
import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
    Author addAuthor(Author author);
    AuthorDTO getAuthorById(int id);
    Author updateAuthor(int id, Author updatedAuthor);
    boolean deleteAuthor(int id);

}
