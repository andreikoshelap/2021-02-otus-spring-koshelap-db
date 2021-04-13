package ru.otus.spring.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import ru.otus.spring.dao.BookDao;
import ru.otus.spring.dao.CommentDao;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

@DataJpaTest
@Import({ GenreDaoImpl.class, AuthorDaoImpl.class, BookDaoImpl.class, CommentDaoImpl.class })
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private CommentDao commentDao;

    private final int EXPECTED_NUMBER_OF_BOOKS = 2;
    private final int EXPECTED_NUMBER_OF_COMMENTS = 1;

    @Test
    public void testGetBookList() {

        List<Book> books = bookDao.getBooksListByGenre("d");

        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(g -> !g.getName().equals(""));
    }

    @Test
    public void testGetBook() {
        Book book  = bookDao.getById(7L);
        List<Comment> comments = book.getComments();

        assertThat(comments).isNotNull().hasSize(EXPECTED_NUMBER_OF_COMMENTS)
                .allMatch(g -> !g.getCommentText().equals(""));
    }

    @Test
    public void testGetBookByGenre() {

        List<Book> books = bookDao.getBooksListByGenre("a");

        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(b -> !b.getName().equals(""));
    }

    @Test
    public void testInsert() throws Exception {
        Book book =  bookDao.getById(7L);
        assertThat(book.getComments()).hasSize(1);

        Comment comment = new Comment();
        comment.setCommentText("This is worst book");
        book.addComment(comment);
        commentDao.save(comment);
        bookDao.save(book);
        assertThat(book.getComments()).hasSize(2);


    }

}
