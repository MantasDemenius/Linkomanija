package com.linkomanija.backend.repository;

import com.linkomanija.backend.domain.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
  UserAdmin findByUsername(String username);
}
