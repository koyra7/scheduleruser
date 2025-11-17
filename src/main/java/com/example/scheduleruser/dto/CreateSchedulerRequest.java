package com.example.scheduleruser.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateSchedulerRequest {

    private String name;
    private String title;
    private String content;
}
