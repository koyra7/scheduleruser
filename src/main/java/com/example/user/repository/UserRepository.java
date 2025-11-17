package com.example.user.repository;

import com.example.scheduleruser.entity.Scheduler;
import com.example.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findByScheduler(Scheduler scheduler);
}
