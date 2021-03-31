package ru.otus.spring.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(targetEntity = Genre.class, cascade = ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(cascade = PERSIST,  targetEntity = Comment.class,  orphanRemoval = true, fetch= FetchType.EAGER )
    @JoinColumn(name = "book_id")
    private List<Comment> comments = new ArrayList<>();


    public Book(long id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
    public Book(long id, String name, Author author, Genre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

     public void addComment(Comment comment) {
        comments.add(comment);
    }
}
