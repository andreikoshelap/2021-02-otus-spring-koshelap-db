package ru.otus.spring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Genre {

    @Id
    private String id;
    private String genreName;
    private String genreKey;

    public Genre(String genreName, String genreKey) {
        this.genreName = genreName;
        this.genreKey = genreKey;
    }
}
