package com.linkomanija.backend.repository;

import com.linkomanija.backend.domain.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTheatreRepository extends JpaRepository<MovieTheatre, Long> {
}
