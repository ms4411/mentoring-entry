package com.example.entry.domain.User;

import com.example.entry.global.common.entity.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseIdEntity {

    @Column(name = "phone_number", nullable = false)
    String phoneNum;

    @Column(name = "password", nullable = false)
    String pw;
}
