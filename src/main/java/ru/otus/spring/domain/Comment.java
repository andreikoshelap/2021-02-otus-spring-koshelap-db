package ru.otus.spring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Comment {

    @Id
    private String id;
    private String commentText;
    private Book book;

    public Comment(String commentText, Book book) {
        this.commentText = commentText;
        this.book = book;
    }
}
