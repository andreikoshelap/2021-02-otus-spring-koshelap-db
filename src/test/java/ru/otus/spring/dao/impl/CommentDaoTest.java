package ru.otus.spring.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import ru.otus.spring.dao.CommentDao;
import ru.otus.spring.domain.Comment;

@DataJpaTest
@Import({ CommentDaoImpl.class })
public class CommentDaoTest {

    @Autowired
    private CommentDao commentDao;

    @Test
    public void testInsert() throws Exception {
        Comment comment = new Comment("Kapital is the best");

        Comment newComment = commentDao.save(comment);

        assertThat(newComment).usingRecursiveComparison().isEqualTo(comment);
    }
}
