package com.example.scheduleruser.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "schedulers")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Scheduler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4)
    private String name;

    @Column(length = 10)
    private String title;

    private String content;
    private LocalDate createDate;
    private LocalDate insertDate;

    public Scheduler(String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.createDate = LocalDate.now();
        this.insertDate = LocalDate.now();
    }

    public void update(String name,String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.insertDate = LocalDate.now();
    }
}
