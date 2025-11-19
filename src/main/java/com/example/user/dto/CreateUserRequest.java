package com.example.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateUserRequest {

    @NotBlank(message = "적어주세요.")
    @Size(max = 4)
    private String name;

    private String email;
    private Long password;
}
