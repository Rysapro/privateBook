package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer>{
    //Optional<Book> findByTitleAndAuthor(String title, String author);

}
