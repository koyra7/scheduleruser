package com.example.user.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GetUserResponse {

    private final Long id;
    private final String name;
    private final String email;
    private LocalDate createdate;
    private LocalDate insertdate;

    public GetUserResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdate = LocalDate.now();
        this.insertdate = LocalDate.now();
    }
}
