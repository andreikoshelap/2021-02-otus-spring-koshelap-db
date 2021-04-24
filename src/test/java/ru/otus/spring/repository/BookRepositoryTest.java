package ru.otus.spring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void testGetBook() {
        var books = bookRepository.findAll();

        assertThat(books).isNotNull().hasSize(7);
    }

    @Test
    public void testGetBookByGenre() {
        var books = bookRepository.findByGenreGenreKey("a");

        assertThat(books).isNotNull().hasSize(2)
                .allMatch(b -> !b.getName().equals(""));
    }
}
