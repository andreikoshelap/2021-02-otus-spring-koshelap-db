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
    private int bookId;

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(@ShellOption(defaultValue = "Dear reader") String userName) {
        this.userName = userName;
        return String.format("Welcome, %s", userName);
    }

    @ShellMethod(value = "Show available genres", key = {"g", "genre"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public String publishEvent() {
        genreEventsPublisher.publishGenre();
        return "Pick book list of defined genre by command 'b {first symbol of genre}' or just 'b' for all books";
    }

    @ShellMethod(value = "Show available books", key = {"b", "book", "books"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public String publishBooks(@ShellOption(defaultValue = "") String genreKey) {
        booksPublisher.publishBooks(genreKey);
        return "Pick another genre by command 'b {first symbol of genre}' or pick book by command 'i {number of book id in this list}'";
    }

    @ShellMethod(value = "Pick available book from list", key = {"i", "I", "id"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public String chooseBook(@ShellOption() int bookId) {
        this.bookId = bookId;
        booksPublisher.publishBookWithComments(bookId);
        return "Add your comment by 'c {comment text}'";
    }

    @ShellMethod(value = "Add comment", key = {"c", "C"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public String addComment(@ShellOption() String comment) {
        booksPublisher.publishBookWithNewComments(bookId, comment);
        return "Add your comment by 'c {comment text with quotation marks}'";
    }

    private Availability isPublishEventCommandAvailable() {
        return userName == null? Availability.unavailable("First login"): Availability.available();
    }
}
