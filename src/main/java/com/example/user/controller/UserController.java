package com.example.user.controller;

import com.example.config.PasswordEncoder;
import com.example.sign.dto.LoginRequest;
import com.example.sign.dto.LoginResponse;
import com.example.user.dto.*;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    // 유저 생성
    @PostMapping("/schedulers/{schedulerId}/users")
    public ResponseEntity<CreateUserResponse> createUser(
            @PathVariable Long schedulerId,
            @Valid
            @RequestBody CreateUserRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(schedulerId, request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request,
            HttpServletRequest httpRequest
    ) {
        User loginUser = userService.login(request.getEmail(), request.getPassword().toString());
        httpRequest.getSession().setAttribute("loginUser", loginUser);
        LoginResponse response = new LoginResponse(
                loginUser.getId(), loginUser.getName(), loginUser.getEmail()
        );
        return ResponseEntity.ok(response);
    }

    // 유저 검색
    @GetMapping("/schedulers/{schedulerId}/users")
    public ResponseEntity<List<GetUserResponse>>  getUsers(
            @PathVariable Long schedulerId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll(schedulerId));
    }

    @GetMapping("/schedulers/{schedulerId}/users/{userId}")
    public ResponseEntity<GetUserResponse>  getUser(
            @PathVariable Long userId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getOne(userId));
    }

    @PutMapping("/schedulers/{schedulerId}/users/{userId}")
    public ResponseEntity<UpdateUserResponse> updateUser(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userId, request));
    }

    @DeleteMapping("/schedulers/{schedulerId}/users/{userId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long userId
    ) {
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
