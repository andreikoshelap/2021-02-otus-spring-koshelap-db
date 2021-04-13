package ru.otus.spring.event.publisher;

public interface BookEventPublisher {
    void publishBooks(String key);

    void publishBookWithComments(int bookId);

    void publishBookWithNewComments( int bookId, String comment);
}
