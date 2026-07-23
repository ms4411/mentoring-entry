package com.example.entry.domain.application;

import com.example.entry.domain.User.User;
import com.example.entry.domain.enums.genderEnum;
import com.example.entry.domain.enums.localEnum;
import com.example.entry.global.common.entity.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@MappedSuperclass
@Getter
public abstract class BaseApplication extends BaseIdEntity{
    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private localEnum area;

    @Column(nullable = false)
    private genderEnum gender;


    @Column(name = "self_introduction")
    private String selfIntroduction;

    @Column(name = "academic_plan")
    private String academicPlan;

}

