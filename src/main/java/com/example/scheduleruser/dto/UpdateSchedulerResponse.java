package com.example.scheduleruser.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UpdateSchedulerResponse {

    private final Long id;
    private final String name;
    private final String title;
    private LocalDate insertdate;

    public UpdateSchedulerResponse(Long id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.insertdate = LocalDate.now();
    }
}
