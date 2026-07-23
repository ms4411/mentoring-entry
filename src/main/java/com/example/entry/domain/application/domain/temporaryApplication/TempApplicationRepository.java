package com.example.entry.domain.application.domain.temporaryApplication;

import com.example.entry.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TempApplicationRepository extends JpaRepository<TempApplication, Long> {
    Optional<TempApplication> findByUser(User user);
}
