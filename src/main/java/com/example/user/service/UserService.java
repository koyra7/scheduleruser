package com.example.user.service;

import com.example.scheduleruser.entity.Scheduler;
import com.example.scheduleruser.repository.SchedulerRepository;
import com.example.user.dto.*;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SchedulerRepository schedulerRepository;

    @Transactional
    public CreateUserResponse save(Long schedulerId, CreateUserRequest request) {
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        User user = new User(request.getName(),request.getEmail(),request.getPassword(), scheduler);
        User saveUser = userRepository.save(user);
        return new CreateUserResponse(
                saveUser.getId(),
                saveUser.getName(),
                saveUser.getEmail()
        );
    }


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
}
