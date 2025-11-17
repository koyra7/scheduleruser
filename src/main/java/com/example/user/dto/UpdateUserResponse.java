package com.example.user.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UpdateUserResponse {

    private final Long id;
    private final String name;
    private final String email;
    private LocalDate insertdate;

    public UpdateUserResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.insertdate = LocalDate.now();
    }
}
