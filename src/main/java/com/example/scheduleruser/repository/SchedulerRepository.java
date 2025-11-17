package com.example.scheduleruser.repository;

import com.example.scheduleruser.entity.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulerRepository extends JpaRepository<Scheduler, Long> {

}
