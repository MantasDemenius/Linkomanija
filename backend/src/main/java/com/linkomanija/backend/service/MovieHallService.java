package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.MovieHall;
import com.linkomanija.backend.repository.MovieHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieHallService {
  private MovieHallRepository movieHallRepository;

  @Autowired
  public MovieHallService(MovieHallRepository movieHallRepository) {
    this.movieHallRepository = movieHallRepository;
  }

  public MovieHall save(MovieHall movieHall) {
    return movieHallRepository.save(movieHall);
  }

  public void delete(MovieHall movieHall) {
    movieHallRepository.delete(movieHall);
  }

  @Transactional
  public int edit(MovieHall movieHall) {
    return movieHallRepository.edit(movieHall.getId(), movieHall.getName(), movieHall.getColumn_count(), movieHall.getRow_count());
  }

  public MovieHall getHall(Long id) {
    return movieHallRepository.findById(id).orElse(new MovieHall());
  }

  public List<MovieHall> getHalls() {
    return movieHallRepository.findAll();
  }
}
