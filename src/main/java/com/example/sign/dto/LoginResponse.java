package com.example.sign.dto;

import lombok.Getter;

@Getter
public class LoginResponse {
    private Long id;
    private String name;
    private String email;

    public LoginResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
