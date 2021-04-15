package ru.otus.spring.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;
import ru.otus.spring.event.BookEvent;

@Component
public class BookEventListener implements ApplicationListener<BookEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(BookEvent bookEvent) {
        Thread.sleep(100);
        bookEvent.getPayload().forEach(book->
            System.out.println(String.format("- %s", book)));
    }
}
