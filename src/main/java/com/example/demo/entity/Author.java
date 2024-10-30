package com.example.demo.entity;

import  jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

@AllArgsConstructor

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private int age;
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;



    public Author() {

    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }


    public Author(String name, String surname, int age, String country) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.country = country;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);  // Назначаем текущего автора книге
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setAuthor(null);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    //тест 1 добавил коммент
}
