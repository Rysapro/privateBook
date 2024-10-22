package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.dto.AuthorDTO;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/findAll")
    public List<AuthorDTO> getAuthors() {
        return authorService.getAuthors().stream()
                .map(AuthorMapper::toAuthorDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable int id){
        AuthorDTO authorDTO = authorService.getAuthorById(id);
        if(authorDTO != null) {
            return new ResponseEntity<>(authorDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public AuthorDTO addAuthor(@RequestBody AuthorDTO authorDTO) {

        Author newAuthor = AuthorMapper.toEntity(authorDTO);
        Author savedAuthor = authorService.addAuthor(newAuthor);
        return AuthorMapper.toAuthorDTO(savedAuthor);
    }

    @PutMapping("delete/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable int id, @RequestBody AuthorDTO authorDTO) {
        Author updatedAuthor = AuthorMapper.toEntity(authorDTO);
        Author savedAuthor = authorService.updateAuthor(id, updatedAuthor);
        if (savedAuthor != null) {
            return new ResponseEntity<>(AuthorMapper.toAuthorDTO(savedAuthor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }




}
