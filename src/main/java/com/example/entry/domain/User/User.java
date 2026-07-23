package com.example.entry.domain.User;

import com.example.entry.global.entity.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class User extends BaseIdEntity {

    @Column(name = "phone_number", nullable = false)
    String phoneNum;

    @Column(name = "password", nullable = false)
    String pw;
}
