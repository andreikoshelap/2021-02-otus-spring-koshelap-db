package ru.otus.spring.changelog;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;

import ru.otus.spring.domain.Harbour;
import ru.otus.spring.domain.Person;
import ru.otus.spring.domain.Ship;

@ChangeLog
public class DatabaseChangelog {

    private Harbour pirita;

    @ChangeSet(order = "001", id = "dropDb", author = "akoshelap", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "initHarbours", author = "akoshelap", runAlways = true)
    public void initHarbours(MongoTemplate template){
        template.save(new Person( "Pirita"));
        template.save(new Person( "Naissaar"));

    }

//    @ChangeSet(order = "001", id = "dropDb", author = "akoshelap", runAlways = true)
//    public void dropDb(MongoDatabase db) {
//        db.drop();
//    }
//
//    @ChangeSet(order = "002", id = "initHarbours", author = "akoshelap", runAlways = true)
//    public void initHarbours(MongoTemplate template){
//        pirita = template.save(new Harbour( "Pirita"));
//        template.save(new Harbour( "Naissaar"));
//
//    }
//
//    @ChangeSet(order = "003", id = "initShips", author = "akoshelap", runAlways = true)
//    public void initShips(MongoTemplate template){
//        template.save(new Ship("sail", "Apollo", pirita));
//        template.save(new Ship("sail", "Mari", pirita));
//    }



}
