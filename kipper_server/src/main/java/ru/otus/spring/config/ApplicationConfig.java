package ru.otus.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.cloudyrock.mongock.Mongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.MongoClient;

@Configuration
public class ApplicationConfig {

    private static final String CHANGELOGS_PACKAGE = "ru.otus.spring.changelog";

    @Bean
    public Mongock mongock(MongoProps mongoProps, MongoClient mongoClient) {
        return new SpringMongockBuilder(mongoClient, mongoProps.getDatabase(), CHANGELOGS_PACKAGE)
                .build();
    }
}
