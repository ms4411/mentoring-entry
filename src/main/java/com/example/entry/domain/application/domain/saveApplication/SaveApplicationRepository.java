package com.example.entry.domain.application.domain.saveApplication;

import com.example.entry.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaveApplicationRepository extends JpaRepository<SaveApplication, Long> {
    Optional<SaveApplication> findByUser(User user);
}
