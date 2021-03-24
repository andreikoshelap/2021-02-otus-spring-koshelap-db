package ru.otus.spring.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.event.publisher.BookEventPublisher;
import ru.otus.spring.event.publisher.GenreEventsPublisher;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsCommands {

    private final GenreEventsPublisher genreEventsPublisher;
    private final BookEventPublisher booksPublisher;
    private String userName;

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(@ShellOption(defaultValue = "Dear reader") String userName) {
        this.userName = userName;
        return String.format("Welcome, %s", userName);
    }

    @ShellMethod(value = "Show available genres", key = {"g", "genre"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public String publishEvent() {
        genreEventsPublisher.publish();
        return "Pick genre for further use";
    }

    @ShellMethod(value = "Show available books", key = {"b", "book", "books"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public String publishBooks(@ShellOption(defaultValue = "classic") String genreKey) {
        booksPublisher.publishBooks(genreKey);
        return "Pick another genre";
    }

    private Availability isPublishEventCommandAvailable() {
        return userName == null? Availability.unavailable("First login"): Availability.available();
    }
}
