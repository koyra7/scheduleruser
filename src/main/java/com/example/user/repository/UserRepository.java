package com.example.user.repository;

import com.example.scheduleruser.entity.Scheduler;
import com.example.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findByScheduler(Scheduler scheduler);

    Optional<User> findByEmail(String email);
}
