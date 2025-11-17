package com.example.scheduleruser.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GetschedulerResponse {

    private final Long id;
    private final String name;
    private final String title;
    private final String content;
    private LocalDate inserdate;

    public GetschedulerResponse(Long id, String name, String title, String content) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.inserdate = LocalDate.now();
    }
}
