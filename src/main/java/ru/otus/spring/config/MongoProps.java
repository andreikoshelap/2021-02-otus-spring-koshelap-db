package ru.otus.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("spring.data.mongodb")
public class MongoProps {
    private int port;
    private String database;
    private String uri;
}
