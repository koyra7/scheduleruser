package com.example.scheduleruser.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateSchedulerResponse {

    private final Long id;
    private final String name;
    private final String title;
    private final String content;
    private final LocalDate createDate;
    private final LocalDate insertDate;

    public CreateSchedulerResponse(Long id, String name, String title,String content) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.createDate = LocalDate.now();
        this.insertDate = LocalDate.now();
    }
}
