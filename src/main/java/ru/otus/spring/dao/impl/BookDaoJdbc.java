package ru.otus.spring.dao.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.dao.mapper.BookMapper;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final GenreDao genreDao;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations, GenreDao genreDao) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.genreDao = genreDao;
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

    @Override
    public List<Book> getBooksList(String genreKey) {
        Genre genre = genreDao.getByKey(genreKey.substring(0,1));
        Map<String, Object> params = Collections.singletonMap("id", genre.getId());
        return namedParameterJdbcOperations.query(
                "select * from book where genre_id = :id order by name", params,
                (resultSet, rowNum) -> {
                    int bookId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    return new Book(bookId, name);
                });

    }

}
