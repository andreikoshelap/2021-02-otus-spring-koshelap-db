package ru.otus.spring.event;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Genre;

public class GenreEvent extends ApplicationEvent {

    @Getter
    private final List<String> payload;

    public GenreEvent(Object source, GenreDao genreDao) {
        super(source);
        payload  = genreDao.getGenreList().stream().map(Genre::getGenreName).collect(Collectors.toList());
    }
}
