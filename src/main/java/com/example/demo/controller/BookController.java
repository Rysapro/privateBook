package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import com.example.demo.dto.BookDTO;
import com.example.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks().stream()
                .map(BookMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {

        Author author = new Author(bookDTO.authorName(), bookDTO.authorSurname(), bookDTO.authorAge(), bookDTO.authorCountry());

        Book newBook = BookMapper.toEntity(bookDTO, author);
        Book savedBook = bookService.addBook(newBook);
        return BookMapper.toBookDTO(savedBook);
    }


    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook){
        return bookService.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        boolean removeIs = bookService.deleteBook(id);
        if (removeIs) {
            return "deleted";
        } else {
            return "id not founded";
        }
    }

}
