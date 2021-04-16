package ru.otus.spring.domain;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "books")
public class Book {
    @Id
    private long id;

    private String name;
    private Author author;
    private List<Genre> genres;

    public Book(String name, Author author, Genre... genres) {
        this.name = name;
        this.author = author;
        this.genres = Arrays.asList(genres);
    }
}
