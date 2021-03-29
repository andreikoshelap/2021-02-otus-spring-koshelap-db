package ru.otus.spring.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import ru.otus.spring.dao.AuthorDao;
import ru.otus.spring.domain.Author;

@DataJpaTest
@Import(AuthorDaoImpl.class)
public class AuthorDaoTest {

    @Autowired
    private AuthorDao authorDao;

    @Test
    public void testGetById() {

        Author author = authorDao.getById(2);

        assertThat(author.getFirstName()).isEqualTo("Walter");
    }

    @Test
    public void testInsert() throws Exception {
        Author expectedAuthor = new Author(99, "Karl", "Marx");

        authorDao.insert(expectedAuthor);

        Author author = authorDao.getById(99);
        assertThat(author).usingRecursiveComparison().isEqualTo(expectedAuthor);
    }

}
