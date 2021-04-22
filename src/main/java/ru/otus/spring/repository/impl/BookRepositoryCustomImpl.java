package ru.otus.spring.repository.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.domain.Book;
import ru.otus.spring.repository.BookRepositoryCustom;

@RequiredArgsConstructor
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Book> findByGenreGenreKey(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("genres.genreKey").is(key));
        return mongoTemplate.find(query, Book.class);

    }

    public List<Book> findByIdWithComments(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.find(query, Book.class);
    }
}
