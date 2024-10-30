package com.example.demo.mapper;

import com.example.demo.entity.Author;
import com.example.demo.domain.dto.AuthorDTO;

public class AuthorMapper {

    public static AuthorDTO toAuthorDTO(Author author) {
        return new AuthorDTO(author.getId(), author.getName(), author.getSurname());
    }

    public static Author toEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setId(authorDTO.id());
        author.setName(authorDTO.name());
        author.setSurname(authorDTO.surname());
        return author;
    }
}
