package ru.otus.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import ru.otus.spring.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    @EntityGraph(attributePaths = {"author", "comments"})
    Optional<Book> findById(long id);

    List<Book> findByGenreGenreKey(String genreKey);

}
