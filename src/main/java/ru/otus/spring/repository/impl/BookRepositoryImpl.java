package ru.otus.spring.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import ru.otus.spring.domain.Book;
import ru.otus.spring.repository.BookRepositoryCustom;

public class BookRepositoryImpl implements BookRepositoryCustom {
    @Autowired
    private EntityManager em;

    @Override
    public Optional<Book> findByIdWithComments(long id) {
        TypedQuery<Book> query = em.createQuery("select b from Book b left outer join fetch b.comments where b.id = :id",
                Book.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }
}
