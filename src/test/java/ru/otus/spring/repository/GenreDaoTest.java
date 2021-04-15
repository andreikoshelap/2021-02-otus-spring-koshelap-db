package ru.otus.spring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ru.otus.spring.domain.Genre;
import ru.otus.spring.repository.GenreRepository;

@DataJpaTest
public class GenreDaoTest {

    private final int EXPECTED_NUMBER_OF_GENRES = 2;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void testGetGenreList() {

        List<Genre> genres = genreRepository.findAll();

        assertThat(genres).isNotNull().hasSize(EXPECTED_NUMBER_OF_GENRES)
                .allMatch(g -> !g.getGenreName().equals(""));
    }

}
