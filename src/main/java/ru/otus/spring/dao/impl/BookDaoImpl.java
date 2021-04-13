package ru.otus.spring.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.util.Strings;
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
        return em.find(Book.class, id, getHintMap());
    }

    @Override
    public Book save(Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public List<Book> getBooksListByGenre(String genreKey) {
        if (Strings.EMPTY.equals(genreKey)) {
            TypedQuery<Book> query = em.createQuery("select b from Book b",
                    Book.class);
            return query.getResultList();
        }
        TypedQuery<Book> query = em.createQuery("select b from Book b left outer join fetch b.genre g where g.genreKey = :genreKey",
                Book.class);
        query.setParameter("genreKey", genreKey);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Comment> getCommentsByBookId(long id, Comment comment) {
        Book book = em.find(Book.class, id, getHintMap());

        book.addComment(comment);
        save(book);
        return book.getComments();
    }

    private Map<String, Object> getHintMap() {
        EntityGraph entityGraph = em.getEntityGraph("graph.Book.comments");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.loadgraph", entityGraph);
        return hints;
    }
}
