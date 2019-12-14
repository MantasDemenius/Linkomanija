package com.linkomanija.backend.repository;

import com.linkomanija.backend.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
