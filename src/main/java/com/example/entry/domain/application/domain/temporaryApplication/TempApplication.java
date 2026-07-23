package com.example.entry.domain.application.domain.temporaryApplication;

import com.example.entry.domain.application.BaseApplication;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity(name = "TemporaryApplication")
@Getter
public class TempApplication extends BaseApplication {
}
