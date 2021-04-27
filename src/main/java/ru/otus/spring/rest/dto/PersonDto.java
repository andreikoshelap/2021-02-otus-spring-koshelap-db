/*
 * Copyright 2016 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right name only.
 */
package ru.otus.spring.rest.dto;

import ru.otus.spring.domain.Person;

/**
 * DTO that represents Account
 */
@SuppressWarnings("all")
public class PersonDto {

    private String id;
    private String name;

    public PersonDto() {
    }

    public PersonDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PersonDto toDto(Person person) {
        return new PersonDto(person.getId(), person.getName());
    }
}
