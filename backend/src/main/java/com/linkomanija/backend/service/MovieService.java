package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.Language;
import com.linkomanija.backend.domain.Movie;
import com.linkomanija.backend.dto.MovieDTO;
import com.linkomanija.backend.repository.LanguageRepository;
import com.linkomanija.backend.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

  private MovieRepository movieRepository;
  private LanguageRepository languageRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository, LanguageRepository languageRepository) {
    this.movieRepository = movieRepository;
    this.languageRepository = languageRepository;
  }

  public Movie addMovie(MovieDTO movieDTO) {
    Language languageById = languageRepository.findById(movieDTO.getLanguage_id()).orElse(new Language());
    Movie movie = new Movie(movieDTO);
    movie.setLanguage(languageById);
    return movieRepository.save(movie);
  }

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  public Movie getMovieById(Long id) {
    return movieRepository.findById(id).orElse(new Movie());
  }

  public Movie editMovie(MovieDTO newMovie) {
    Movie movie = movieRepository.findById(newMovie.getId()).orElse(new Movie());
    Language languageById = languageRepository.findById(newMovie.getLanguage_id()).orElse(new Language());
    movie.updateValues(newMovie, languageById);
    movieRepository.save(movie);
    return movie;
  }

  public Movie deleteMovie(Long id) {
    Movie movie = movieRepository.findById(id).orElse(new Movie());
    movieRepository.delete(movie);
    return movie;
  }
}
