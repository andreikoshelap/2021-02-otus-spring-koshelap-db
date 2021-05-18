package ru.otus.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public Ship() {
    }

    public Ship( String name, String captain) {
        this.name = name;
        this.captain = captain;
    }

    public Ship(String type, String name, String captain, Harbour homeHarbour) {
        this.type = type;
        this.name = name;
        this.captain = captain;
        this.homeHarbour = homeHarbour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getTonnage() {
        return tonnage;
    }

    public void setTonnage(Double tonnage) {
        this.tonnage = tonnage;
    }

    public Double getImmersion() {
        return immersion;
    }

    public void setImmersion(Double immersion) {
        this.immersion = immersion;
    }

    public Harbour getHomeHarbour() {
        return homeHarbour;
    }

    public void setHomeHarbour(Harbour homeHarbour) {
        this.homeHarbour = homeHarbour;
    }
}
