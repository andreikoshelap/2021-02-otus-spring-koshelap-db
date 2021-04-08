package ru.otus.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(unique = true, nullable = false)
    private long id;
    private String commentText;

    public Comment(String commentText) {
        this.commentText = commentText;
    }
}
