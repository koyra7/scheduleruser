package com.example.scheduleruser.service;

import com.example.scheduleruser.dto.CreateSchedulerRequest;
import com.example.scheduleruser.dto.CreateSchedulerResponse;
import com.example.scheduleruser.dto.GetschedulerResponse;
import com.example.scheduleruser.dto.UpdateSchedulerRequest;
import com.example.scheduleruser.entity.Scheduler;
import com.example.scheduleruser.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final SchedulerRepository schedulerRepository;

    @Transactional
    public CreateSchedulerResponse save(CreateSchedulerRequest request) {
        Scheduler scheduler = new Scheduler(
                request.getName(),
                request.getTitle(),
                request.getContent()
        );
        Scheduler saveScheduler = schedulerRepository.save(scheduler);
        return new CreateSchedulerResponse(
                saveScheduler.getId(),
                saveScheduler.getName(),
                saveScheduler.getTitle(),
                saveScheduler.getContent()
        );
    }

    @Transactional(readOnly = true)
    public List<GetschedulerResponse> getAll() {
        List<Scheduler> schedulers = schedulerRepository.findAll();
        List<GetschedulerResponse> dtos = new ArrayList<>();
        for(Scheduler scheduler : schedulers) {
            GetschedulerResponse dto = new GetschedulerResponse(
                    scheduler.getId(),
                    scheduler.getName(),
                    scheduler.getTitle(),
                    scheduler.getContent()
            );
            dtos.add(dto);
        }
        {
            return dtos;
        }
    }

    @Transactional(readOnly = true)
    public GetschedulerResponse getOne(Long schedulerId) {
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        return new  GetschedulerResponse(
                scheduler.getId(),
                scheduler.getName(),
                scheduler.getTitle(),
                scheduler.getContent()
        );
    }

    @Transactional
    public CreateSchedulerResponse update(Long schedulerId, UpdateSchedulerRequest request) {
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        scheduler.update(request.getName(),request.getTitle(),request.getContent());
        return new CreateSchedulerResponse(
                scheduler.getId(),
                scheduler.getName(),
                scheduler.getTitle(),
                scheduler.getContent()
        );
    }

    @Transactional
    public void delete(Long schedulerId) {
        boolean existence = schedulerRepository.existsById(schedulerId);
        if( !existence) {
            throw new IllegalStateException("없는 일정입니다.");
        }
        schedulerRepository.deleteById(schedulerId);
    }
}
