package ru.otus.spring.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import ru.otus.spring.dao.BookDao;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

@DataJpaTest
@Import({ BookDaoImpl.class, GenreDaoImpl.class })
public class CommentDaoTest {

    @Autowired
    private BookDao bookDao;

    private final int EXPECTED_NUMBER_OF_COMMENTS = 1;

    @Test
    public void testGetBookList() {
        Book book  = bookDao.getById(7L);
        List<Comment> comments = book.getComments();

        assertThat(comments).isNotNull().hasSize(EXPECTED_NUMBER_OF_COMMENTS)
                .allMatch(g -> !g.getCommentText().equals(""));
    }

}
