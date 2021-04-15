package ru.otus.spring.domain;

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

    private String book;

    public Book(String book) {
        this.book = book;
    }
}
