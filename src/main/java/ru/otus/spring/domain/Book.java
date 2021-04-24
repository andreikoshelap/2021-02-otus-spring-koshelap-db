package ru.otus.spring.domain;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Book {
    @Id
    private String id;
    private long bookKey;
    private String name;
    private Author author;
    private List<Genre> genres;

    public Book(long bookKey, String name, Author author, Genre... genres) {
        this.bookKey = bookKey;
        this.name = name;
        this.author = author;
        this.genres = Arrays.asList(genres);
    }
}
