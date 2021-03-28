package ru.otus.spring.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import ru.otus.spring.dao.BookDao;
import ru.otus.spring.domain.Book;

@JdbcTest
@Import({GenreDaoJdbc.class, AuthorDaoJdbc.class, BookDaoJdbc.class })
public class BookDaoJdbcTest {

    @Autowired
    private BookDao bookDao;

    private final int EXPECTED_NUMBER_OF_GENRES = 2;

    @Test
    public void testGetBookList() {

        List<Book> books = bookDao.getBooksList("detective");

        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_GENRES)
                .allMatch(g -> !g.getName().equals(""));
    }

}
