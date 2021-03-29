package ru.otus.spring.dao.impl;

import java.util.Collections;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.dao.mapper.AuthorMapper;
import ru.otus.spring.domain.Author;

@Repository
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public Author getById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select id, first_name, last_name from author where id = :id", params, new AuthorMapper()
        );
    }

    @Override
    public void insert(Author author) {
        namedParameterJdbcOperations.update("insert into author (id, first_name, last_name) values (:id, :first_name, :last_name)",
                Map.of("id", author.getId(), "first_name", author.getFirstName(), "last_name", author.getLastName()));
    }

}
