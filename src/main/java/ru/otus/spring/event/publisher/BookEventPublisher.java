package ru.otus.spring.event.publisher;

public interface BookEventPublisher {
    void publishBooks(String key);

    void publishBookWithComments(String key, int bookKey);

    void publishBookWithNewComments(String key, int bookKey, String comment);
}
