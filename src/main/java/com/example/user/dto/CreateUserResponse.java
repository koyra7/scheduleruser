package com.example.user.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateUserResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final LocalDate createDate;
    private final LocalDate insertDate;

    public CreateUserResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createDate = LocalDate.now();
        this.insertDate = LocalDate.now();
    }
}
