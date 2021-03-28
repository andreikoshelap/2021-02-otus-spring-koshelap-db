package ru.otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Book {
    private long id;
    private String name;
    private Author author;
    private Genre genre;

    public Book(long id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
