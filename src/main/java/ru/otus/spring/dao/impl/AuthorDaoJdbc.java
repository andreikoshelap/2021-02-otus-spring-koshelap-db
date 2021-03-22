package ru.otus.spring.dao.impl;

import java.util.Collections;
import java.util.Map;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.dao.mapper.AuthorMapper;
import ru.otus.spring.domain.Author;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final JdbcOperations jdbc;

    public AuthorDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.jdbc = namedParameterJdbcOperations.getJdbcOperations();
    }

    @Override
    public Author getById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select * from author where id = :id", params, new AuthorMapper()
        );
    }

    @Override
    public void insert(Author author) {
        namedParameterJdbcOperations.update("insert into book (id, 'name', author_id, genre_id) values (:id, :name, :author_id, :genre_id)",
                Map.of("id", author.getId(), "first_name", author.getFirstName(), "last_name", author.getLastName()));
    }

    @Override
    public String count() {
        return  jdbc.queryForObject("select count(*) from author", Integer.class).toString();
    }

    //    public static class AuthorMapper implements RowMapper<Author> {
//
//        @Override
//        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
//            long id = resultSet.getLong("id");
//            String firstName = resultSet.getString("first_name");
//            String lastName = resultSet.getString("last_name");
//            return new Author(id, firstName, lastName);
//        }
//    }

}
