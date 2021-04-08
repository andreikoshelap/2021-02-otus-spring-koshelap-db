package ru.otus.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

@Repository
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Book getById(long id) {
        TypedQuery<Book> query = em.createQuery("select b from Book b left outer join fetch b.comments where b.id = :id",
                Book.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Book save(Book book) {
            em.persist(book);
            return book;
    }

    @Override
    public List<Book> getBooksListByGenre(String genreKey) {
        TypedQuery<Book> query = em.createQuery("select b from Book b left outer join fetch b.genre g where g.genreKey = :genreKey",
                Book.class);
        query.setParameter("genreKey", genreKey);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Comment> getCommentsByBookId(long id, Comment comment) {
        TypedQuery<Book> query = em.createQuery("select b from Book b left outer join fetch b.comments where b.id = :id",
                Book.class);
        query.setParameter("id", id);
        Book book = query.getSingleResult();
        book.addComment(comment);
        save(book);
        return book.getComments();
    }
}
