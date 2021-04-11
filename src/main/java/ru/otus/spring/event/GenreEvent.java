package ru.otus.spring.event;

import static java.util.stream.StreamSupport.stream;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import ru.otus.spring.repository.GenreRepository;
import ru.otus.spring.domain.Genre;

public class GenreEvent extends ApplicationEvent {

    @Getter
    private final List<String> payload;

    public GenreEvent(Object source, GenreRepository genreDao) {
        super(source);
        payload  = stream(genreDao.findAll().spliterator(), false).map(Genre::getGenreName).collect(Collectors.toList());
    }
}
