package ru.otus.spring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Document
public class Comment {

    @Id
    private long id;
    private String commentText;

    public Comment(String commentText) {
        this.commentText = commentText;
    }
}
