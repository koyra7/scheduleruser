package com.example.user.controller;

import com.example.scheduleruser.dto.GetschedulerResponse;
import com.example.user.dto.*;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/schedulers/{schedulerId}/users")
    public ResponseEntity<CreateUserResponse> createUser(
            @PathVariable Long schedulerId,
            @RequestBody CreateUserRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(schedulerId, request));
    }

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
