package com.example.scheduleruser.controller;

import com.example.scheduleruser.dto.CreateSchedulerRequest;
import com.example.scheduleruser.dto.CreateSchedulerResponse;
import com.example.scheduleruser.dto.GetschedulerResponse;
import com.example.scheduleruser.dto.UpdateSchedulerRequest;
import com.example.scheduleruser.repository.SchedulerRepository;
import com.example.scheduleruser.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchedulerController {

    private final SchedulerService schedulerService;
    private final SchedulerRepository schedulerRepository;

    // 생성
    @PostMapping("/schedulers")
    public ResponseEntity<CreateSchedulerResponse> createScheduler(
            @RequestBody CreateSchedulerRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(schedulerService.save(request));
    }

    // 전체 조회
    @GetMapping("/schedulers")
    public ResponseEntity<List<GetschedulerResponse>> getSchedulers() {
        return ResponseEntity.status(HttpStatus.OK).body(schedulerService.getAll());
    }

    // 단일 조회
    @GetMapping("/schedulers/{schedulerId}")
    public ResponseEntity<GetschedulerResponse>  getScheduler(
            @PathVariable Long schedulerId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(schedulerService.getOne(schedulerId));
    }

    @PutMapping("/schedulers/{schedulerId}")
    public ResponseEntity<CreateSchedulerResponse> updateScheduler(
            @PathVariable Long schedulerId,
            @RequestBody UpdateSchedulerRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(schedulerService.update(schedulerId, request));
    }

    @DeleteMapping("/schedulers/{schedulerId}")
    public ResponseEntity<Void> deleteScheduler(
            @PathVariable Long schedulerId
    ) {
        schedulerService.delete(schedulerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
