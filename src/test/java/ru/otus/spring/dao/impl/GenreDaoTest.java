package ru.otus.spring.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Genre;

@DataJpaTest
@Import(GenreDaoImpl.class)
public class GenreDaoTest {

    private final int EXPECTED_NUMBER_OF_GENRES = 2;

    @Autowired
    private GenreDao genreDao;

    @Test
    public void testGetGenreList() {

        List<Genre> genres = genreDao.getGenreList();

        assertThat(genres).isNotNull().hasSize(EXPECTED_NUMBER_OF_GENRES)
                .allMatch(g -> !g.getGenreName().equals(""));
    }

    @Test
    public void testInsert() throws Exception {
        Genre expectedGenre = new Genre(6, "adventure");

        Genre genre = genreDao.getByKey("a");

        assertThat(genre).usingRecursiveComparison().isEqualTo(expectedGenre);
    }

}
