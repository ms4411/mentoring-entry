package com.example.entry.domain.application.dto;

import com.example.entry.domain.enums.AreaEnum;
import com.example.entry.domain.enums.GenderEnum;

import java.time.LocalDate;

public record PersonalDataDTO(
        Long id,
        String name,
        LocalDate birthday,
        AreaEnum area,
        GenderEnum gender
) {
}
