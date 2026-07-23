package com.example.entry.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum genderEnum {
    WOMAN("woman"),
    MAN("man");

    final String label;
}
