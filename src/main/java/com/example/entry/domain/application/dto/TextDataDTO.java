package com.example.entry.domain.application.dto;

import jakarta.validation.constraints.Size;

public record TextDataDTO(
        @Size(max=1600)
        String text,
        Long id
) {
}
