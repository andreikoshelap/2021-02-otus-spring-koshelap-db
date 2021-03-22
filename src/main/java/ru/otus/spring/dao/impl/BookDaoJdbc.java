package ru.otus.spring.dao.impl;

import java.util.Collections;
import java.util.Map;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.mapper.BookMapper;
import ru.otus.spring.domain.Book;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final JdbcOperations jdbc;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.jdbc = namedParameterJdbcOperations.getJdbcOperations();
    }

    @Override
    public Book getById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select * from book where id = :id", params, new BookMapper()
        );
    }

    @Override
    public void insert(Book book) {
        namedParameterJdbcOperations.update("insert into book (id, 'name', author_id, genre_id) values (:id, :name, :author_id, :genre_id)",
                Map.of("id", book.getId(), "name", book.getName(), "author_id", book.getAuthor().getId(), "genre_id", book.getGenre().getId()));
    }

    @Override public String count() {
        return  jdbc.queryForObject("select count(*) from book", Integer.class).toString();
    }

}
