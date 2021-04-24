package ru.otus.spring.repository;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;

@DataMongoTest
@EnableConfigurationProperties
@AutoConfigureDataMongo
@ComponentScan({"ru.otus.spring.config", "ru.otus.spring.repository"})
public abstract class AbstractRepositoryTest {
}
