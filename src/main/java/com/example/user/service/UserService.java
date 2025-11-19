package com.example.user.service;

import com.example.config.PasswordEncoder;
import com.example.scheduleruser.entity.Scheduler;
import com.example.scheduleruser.repository.SchedulerRepository;
import com.example.user.dto.*;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SchedulerRepository schedulerRepository;
    private final PasswordEncoder passwordEncoder;

    // 유저 생성
    @Transactional
    public CreateUserResponse save(Long schedulerId, CreateUserRequest request) {
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        // 암호화
        String encodedPw = passwordEncoder.encode(request.getPassword().toString());
        User user = new User(
                request.getName(),
                request.getEmail(),
                // 암호화로 리턴
                encodedPw,
                scheduler
        );
        User saveUser = userRepository.save(user);
        return new CreateUserResponse(
                saveUser.getId(),
                saveUser.getName(),
                saveUser.getEmail()
        );
    }


    // 유저 검색
    @Transactional(readOnly = true)
    public List<GetUserResponse> getAll(Long schedulerId) {
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        List<User> users = userRepository.findByScheduler(scheduler);
        return users.stream().map(user -> new GetUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        )).toList();
    }


    @Transactional(readOnly = true)
    public GetUserResponse getOne(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        return new GetUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }


    @Transactional
    public UpdateUserResponse update(Long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        user.update(request.getName(), request.getEmail());
        return new UpdateUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }


    @Transactional
    public void delete(Long userId) {
        boolean existence = userRepository.existsById(userId);
        if( !existence) {
            throw new IllegalStateException("없는 유저입니다.");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public User login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        User user = optionalUser.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "이메일이 틀렸습니다."));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, " 비밀번호가 일치하지 않습니다.");
        }
        return user;
    }
}
