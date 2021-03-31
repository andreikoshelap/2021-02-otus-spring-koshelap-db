package ru.otus.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.CommentDao;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.domain.Genre;

@Repository
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private final GenreDao genreDao;
    @Autowired
    private final CommentDao commentDao;


    @Override
    public Book getById(long id) {
        return em.find(Book.class, id);
    }

    @Override
    public Book addComment(Book book) {
        if (book.getId() == 0) {
            em.persist(book);
            return book;
        } else {
            return em.merge(book);
        }
    }

    @Override
    public List<Book> getBooksList(String genreKey) {
        Genre genre = genreDao.getByKey(genreKey.substring(0, 1));
        TypedQuery<Book> query = em.createQuery("select b from Book b where b.genre = :genre",
                Book.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    @Override
    public Book getBook(String genreKey, int bookKey) {
        List<Book> books = getBooksList(genreKey);
        return books.get(bookKey-1);
    }

    @Override
    public List<Comment> addComment(String genreKey, int bookKey, String commentText) {
        Book book = getBook(genreKey, bookKey);
        Comment comment = new Comment(commentText);
        book.addComment(comment);
        return book.getComments();
    }
}
