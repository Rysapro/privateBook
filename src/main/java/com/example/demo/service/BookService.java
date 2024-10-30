package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book addBook(Book book);
    Book updateBook(int id, Book updatedBook);
    boolean deleteBook(int id);
}
