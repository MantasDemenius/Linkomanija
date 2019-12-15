package com.linkomanija.backend.repository;

import com.linkomanija.backend.domain.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
  List<Timetable> findByUserEmployeeId(Long user_employee_id);
}
