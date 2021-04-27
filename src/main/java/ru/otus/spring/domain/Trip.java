package ru.otus.spring.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Document
public class Trip {

    @Id
    private String id;
    private Ship ship;
    private String pointStart;
    private String pointFinish;
    private int crewQuantity;
    private LocalDate dateStart;
    private LocalTime timeStart;
    private LocalDate expectedDateFinish;
    private LocalTime expectedTimeFinish;
    private LocalDate actualDateFinish;
    private LocalTime actualTimeFinish;
    private String events;
    private Double expectedDistance;
    private Double actualDistance;

    public Trip() {

    }

    public Trip(String id, String events) {
        this.id = id;
        this.events = events;
    }
}
