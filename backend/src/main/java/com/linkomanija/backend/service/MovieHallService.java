package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.MovieHall;
import com.linkomanija.backend.domain.MovieTheatre;
import com.linkomanija.backend.dto.MovieHallDTO;
import com.linkomanija.backend.repository.MovieHallRepository;
import com.linkomanija.backend.repository.MovieTheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieHallService {
  private MovieHallRepository movieHallRepository;
  private MovieTheatreRepository movieTheatreRepository;

  @Autowired
  public MovieHallService(MovieHallRepository movieHallRepository, MovieTheatreRepository movieTheatreRepository) {
    this.movieHallRepository = movieHallRepository;
    this.movieTheatreRepository = movieTheatreRepository;
  }

  public MovieHall addMovieHall(MovieHallDTO movieHallDTO) {
    MovieTheatre movieTheatreById = movieTheatreRepository.findById(movieHallDTO.getMovie_theatre_id()).orElse(new MovieTheatre());
    MovieHall movieHall = new MovieHall(movieHallDTO);
    movieHall.setMovieTheatre(movieTheatreById);
    return movieHallRepository.save(movieHall);
  }

  public List<MovieHall> getAllMovieHalls() {
    return movieHallRepository.findAll();
  }

  public MovieHall getMovieHallById(Long id) {
    return movieHallRepository.findById(id).orElse(new MovieHall());
  }

  public MovieHall editMovieHall(MovieHallDTO movieHallDTO) {
    MovieHall movieHall = movieHallRepository.findById(movieHallDTO.getId()).orElse(new MovieHall());
    MovieTheatre movieTheatreById = movieTheatreRepository.findById(movieHallDTO.getMovie_theatre_id()).orElse(new MovieTheatre());
    movieHall.updateValues(movieHallDTO, movieTheatreById);
    return movieHallRepository.save(movieHall);
  }

  public MovieHall deleteMovieHall(Long id) {
    MovieHall movieHall = movieHallRepository.findById(id).orElse(new MovieHall());
    movieHallRepository.delete(movieHall);
    return movieHall;
  }
}
