package com.linkomanija.backend.repository;

import com.linkomanija.backend.domain.UserEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEmployeeRepository extends JpaRepository<UserEmployee, Long> {
}
