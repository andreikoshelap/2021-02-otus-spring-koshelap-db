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
public class Ship {

    @Id
    private String id;
    private String type;
    private String name;
    private String captain;
    private Double length;
    private Double width;
    private Double tonnage;
    private Double immersion;
    private Harbour homeHarbour;

    public Ship(String type, String name, Harbour homeHarbour) {
        this.type = type;
        this.name = name;
    }
}
