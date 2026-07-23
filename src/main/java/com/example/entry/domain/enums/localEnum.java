package com.example.entry.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum localEnum {
    LOCAL("local", "대전"),
    GLOBAL("global", "전국");

    final String en;
    final String ko;
}
