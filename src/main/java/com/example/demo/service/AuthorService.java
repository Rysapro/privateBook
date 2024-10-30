package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.dto.AuthorDTO;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

//    private List<Author> authors = new ArrayList<>();
//    private int nextId = 1;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);

//        author.setId(nextId++);
//        authors.add(author);
//        return author;
    }

    public AuthorDTO getAuthorById(int id) {
        return authorRepository.findById(id)
                .map(AuthorMapper::toAuthorDTO)
                .orElse(null);
    }


    public Author updateAuthor(int id, Author updatedAuthor) {
        Optional<Author> existingAuthor = authorRepository.findById(id);
        if (existingAuthor.isPresent()) {
            Author author = existingAuthor.get();
            author.setName(updatedAuthor.getName());
            author.setSurname(updatedAuthor.getSurname());
            author.setAge(updatedAuthor.getAge());
            author.setCountry(updatedAuthor.getCountry());
            return authorRepository.save(author);
        }
        return null;
    }

    public boolean deleteAuthor(int id) {
        if (authorRepository.existsById(id)){
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

