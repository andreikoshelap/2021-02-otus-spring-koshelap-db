package ru.otus.spring.dao.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.dao.mapper.BookMapper;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

@Repository
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final GenreDao genreDao;
    private final AuthorDao authorDao;


    @Override
    public Book getById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select id, name, author_id, genre_id from book where id = :id", params, new BookMapper()
        );
    }

    @Override
    public void insert(Book book) {
        namedParameterJdbcOperations.update("insert into book (id, 'name', author_id, genre_id) values (:id, :name, :author_id, :genre_id)",
                Map.of("id", book.getId(), "name", book.getName(), "author_id", book.getAuthor().getId(), "genre_id", book.getGenre().getId()));
    }

    @Override
    public List<Book> getBooksList(String genreKey) {
        Genre genre = genreDao.getByKey(genreKey.substring(0, 1));
        Map<String, Object> params = Collections.singletonMap("id", genre.getId());
        return namedParameterJdbcOperations.query(
                "select b.id as bid, b.name, a.id as aid, a.first_name, a.last_name from book b join author a where b.genre_id = :id and b.author_id = a.id order by name",
                params,
                (resultSet, rowNum) -> {
                    int bookId = resultSet.getInt("bid");
                    String name = resultSet.getString("name");
                    int authorId = resultSet.getInt("aid");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    Author author = new Author(authorId, firstName, lastName);
                    return new Book(bookId, name, author);
                });

    }

}
