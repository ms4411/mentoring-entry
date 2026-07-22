package com.example.entry.application;

import com.example.entry.User.User;
import com.example.entry.global.entity.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
@Immutable
@Entity
public class Application extends BaseIdEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private Boolean area;

    @Column(nullable = false)
    private String gender;


    @Column(name = "self_introduction")
    private String selfIntroduction;

    @Column(name = "academic_plan")
    private String academicPlan;

}
