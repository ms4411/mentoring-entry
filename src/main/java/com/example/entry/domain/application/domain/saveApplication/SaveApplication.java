package com.example.entry.domain.application.domain.saveApplication;

import com.example.entry.domain.application.BaseApplication;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Immutable
@Entity
@Getter
public class SaveApplication extends BaseApplication {
}
