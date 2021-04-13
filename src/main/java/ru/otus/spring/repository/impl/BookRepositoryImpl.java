package ru.otus.spring.repository.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import ru.otus.spring.domain.Book;
import ru.otus.spring.repository.BookRepositoryCustom;

public class BookRepositoryImpl implements BookRepositoryCustom {
    @Autowired
    private EntityManager em;

    @Override
    public Optional<Book> findByIdWithComments(long id) {
        EntityGraph entityGraph = em.getEntityGraph("graph.Book.comments");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.loadgraph", entityGraph);
        return  Optional.ofNullable(em.find(Book.class, id, hints));
    }

}
