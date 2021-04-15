package ru.otus.spring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private final int EXPECTED_NUMBER_OF_BOOKS = 2;
    private final int EXPECTED_NUMBER_OF_COMMENTS = 1;

    @Test
    public void testGetBook() {
        Book book = bookRepository.findById(7L).get();
        List<Comment> comments = book.getComments();

        assertThat(comments).isNotNull().hasSize(EXPECTED_NUMBER_OF_COMMENTS)
                .allMatch(g -> !g.getCommentText().equals(""));
    }

    @Test
    public void testGetBookByGenre() {

        List<Book> books = bookRepository.findByGenreGenreKey("a");

        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(b -> !b.getName().equals(""));
    }

    @Test
    public void testInsert(){
        Book book = bookRepository.findById(7L).get();
        assertThat(book.getComments()).hasSize(1);

        Comment comment = new Comment();
        comment.setCommentText("This is the worst book");
        book.addComment(comment);
        bookRepository.save(book);
        assertThat(book.getComments()).hasSize(2);
    }

    @Test
    public void testBookOutputWithComments() {
        Book book = bookRepository.findById(3L).get();

        assertThat(book.getName()).isEqualTo("Ivanhoe");
        assertThat(book.getComments()).hasSize(1).extracting(Comment::getCommentText).containsExactly("My favorite romantic novel.");
    }
}
