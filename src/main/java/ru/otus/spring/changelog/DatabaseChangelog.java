package ru.otus.spring.changelog;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;

import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.domain.Genre;

@ChangeLog
public class DatabaseChangelog {

    private Genre fiction;
    private Genre tale;
    private Genre classic;
    private Genre adventure;
    private Genre detective;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;
    private Book book7;

    @ChangeSet(order = "001", id = "dropDb", author = "akoshelap", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "initGenres", author = "akoshelap", runAlways = true)
    public void initGenres(MongoTemplate template){
        fiction = template.save(new Genre("fiction", "f"));
        tale = template.save(new Genre("tale", "t"));
        classic = template.save(new Genre("classic", "c"));
        adventure = template.save(new Genre("adventure", "a"));
        detective = template.save(new Genre("detective", "d"));
    }

    @ChangeSet(order = "003", id = "initBooks", author = "akoshelap", runAlways = true)
    public void initBooks(MongoTemplate template){
        book1 = template.save(new Book(1L, "Five Little Pigs", new Author("Agatha",  "Christie"), detective));
        book2 = template.save(new Book(2L, "The Clocks", new Author("Agatha",  "Christie"), detective));
        book3 = template.save(new Book(3L,"Ivanhoe", new Author("Walter",  "Scott"), adventure));
        book4 = template.save(new Book(4L,"Eugenie Grandet", new Author("Honore",  "de Balzac"), classic));
        book5 = template.save(new Book(5L,"I am Robot", new Author("Isaac",  "Asimov"), detective));
        book6 = template.save(new Book(6L,"Tail of the fisherman and the fish", new Author("Alexander",  "Pushkin"), tale));
        book7 = template.save(new Book(7L,"Treasure island", new Author("Robert",  "Stevenson"), adventure));
    }

    @ChangeSet(order = "004", id = "initComments", author = "akoshelap", runAlways = true)
    public void initComments(MongoTemplate template){
        template.save(new Comment("My favorite romantic novel.", book3));
        template.save(new Comment("Is it real story? I saw  series about Flint and his crew named The Pirates. This movie looks close to real life", book7));
    }


}
