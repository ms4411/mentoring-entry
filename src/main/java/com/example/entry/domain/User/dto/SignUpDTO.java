package com.example.entry.domain.User.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SignUpDTO(
        @NotNull
        @Pattern(regexp = "^\\d+$")
        String phoneNumber,
        @NotNull
        @Size(min = 8)
        String password,
        @NotNull
        String checkPassword
) {
}
