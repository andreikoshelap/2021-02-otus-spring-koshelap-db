package ru.otus.spring.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.otus.spring.domain.Book;

public class BookMapper implements RowMapper<Book> {

    private AuthorMapper authorMapper;
    private GenreMapper genreMapper;

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int authorId = resultSet.getInt("author_id");
        int genreId = resultSet.getInt("genre_id");
        return new Book(id, name, authorMapper.mapRow(resultSet, authorId), genreMapper.mapRow(resultSet, genreId));
    }
}
