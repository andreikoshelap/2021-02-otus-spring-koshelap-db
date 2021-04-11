package ru.otus.spring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ru.otus.spring.repository.CommentRepository;
import ru.otus.spring.domain.Comment;

@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void testInsert() throws Exception {
        Comment comment = new Comment("Kapital is the best");

        Comment newComment = commentRepository.save(comment);

        assertThat(newComment).usingRecursiveComparison().isEqualTo(comment);
    }
}
