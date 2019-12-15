package com.linkomanija.backend.repository;

import com.linkomanija.backend.domain.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRating, Long> {
  List<MovieRating> findByMovieId(Long movie_id);
}
