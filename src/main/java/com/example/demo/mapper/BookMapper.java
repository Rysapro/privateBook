package com.example.demo.mapper;

import com.example.demo.Author;
import com.example.demo.Book;
import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.BookDTO;

public class BookMapper {

    public static BookDTO toBookDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor().getName(),
                book.getAuthor().getSurname(),
                book.getAuthor().getAge(),
                book.getAuthor().getCountry(),
                book.getCost()
        );
    }

    public static Book toEntity(BookDTO bookDTO, Author author) {
        Book book = new Book();
        book.setTitle(bookDTO.title());
        book.setAuthor(author);
        book.setCost(bookDTO.cost());
        return book;
    }
}
