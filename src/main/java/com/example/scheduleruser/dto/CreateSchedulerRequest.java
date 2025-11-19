package com.example.scheduleruser.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateSchedulerRequest {

    @NotBlank(message = "적어주세요.")
    @Size(max = 4, message = "이름은 최대 4글자")
    private String name;

    @NotBlank(message = "적어주세요.")
    @Size(max = 10, message = "제목은 최대 10글자")
    private String title;

    private String content;
}
