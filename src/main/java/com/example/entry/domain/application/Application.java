package com.example.entry.domain.application;

import com.example.entry.domain.User.User;
import com.example.entry.domain.enums.AreaEnum;
import com.example.entry.domain.enums.GenderEnum;
import com.example.entry.global.common.entity.BaseIdEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Application extends BaseIdEntity{
    @OneToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private AreaEnum area;

    @Column(nullable = false)
    private GenderEnum gender;


    @Column(name = "self_introduction")
    private String selfIntroduction;

    @Column(name = "academic_plan")
    private String academicPlan;

    @Column(nullable = false)
    private Boolean isSubmit=false;

    public void setPersonalData(String name, LocalDate birthday, AreaEnum area, GenderEnum gender){
        if(this.isSubmit==true){
            return;
        }
        this.name=name;
        this.birthday=birthday;
        this.area=area;
        this.gender=gender;
    }

    public void setSelfIntroduction(String selfIntroduction){
        if(this.isSubmit==true){
            return;
        }
        this.selfIntroduction=selfIntroduction;
    }

    public void setAcademicPlan(String academicPlan){
        if(this.isSubmit==true){
            return;
        }
        this.academicPlan=academicPlan;
    }

    public void submit(){
        this.isSubmit=true;
    }
}

