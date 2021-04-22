package ru.otus.spring.event.publisher;

public interface BookEventPublisher {
    void publishBooks(String key);
//
//    void publishBookWithComments(long bookId);
//
//    void publishBookWithNewComments( long bookId, String comment);
}
