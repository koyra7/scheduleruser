package com.example.user.entity;

import com.example.scheduleruser.entity.Scheduler;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4)
    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private LocalDate createdate;
    private LocalDate insertdate;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "scheduler id", nullable = false)
    private Scheduler scheduler;

    public User(String name, String email,String password, Scheduler scheduler) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.scheduler = scheduler;
        this.createdate = LocalDate.now();
        this.insertdate = LocalDate.now();
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
        this.insertdate = LocalDate.now();
    }


}
