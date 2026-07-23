package com.example.entry.domain.User.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SignInDTO(
        @NotNull
        @Pattern(regexp = "^[0-9]+$")
        String phoneNumber,

        @NotNull
        @Size(min = 8)
        String password
) {
}
