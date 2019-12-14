package com.linkomanija.backend.repository;

import com.linkomanija.backend.domain.MovieHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MovieHallRepository extends JpaRepository<MovieHall, Long> {

  @Modifying
  @Query("update MovieHall m set m.name = ?2, m.column_count = ?3, m.row_count = ?4 where m.id = ?1")
  int edit(Long id, String name, int column_count, int row_count);
}
