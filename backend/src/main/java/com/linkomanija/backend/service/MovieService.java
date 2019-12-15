package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.Language;
import com.linkomanija.backend.domain.Movie;
import com.linkomanija.backend.domain.MovieRating;
import com.linkomanija.backend.dto.MovieDTO;
import com.linkomanija.backend.dto.MovieRatingDTO;
import com.linkomanija.backend.repository.LanguageRepository;
import com.linkomanija.backend.repository.MovieRatingRepository;
import com.linkomanija.backend.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

  private MovieRepository movieRepository;
  private LanguageRepository languageRepository;
  private MovieRatingRepository movieRatingRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository, LanguageRepository languageRepository, MovieRatingRepository movieRatingRepository) {
    this.movieRepository = movieRepository;
    this.languageRepository = languageRepository;
    this.movieRatingRepository = movieRatingRepository;
  }

  public Movie addMovie(MovieDTO movieDTO) {
    Language languageById = languageRepository.findById(movieDTO.getLanguage_id()).orElse(new Language());
    Movie movie = new Movie(movieDTO, languageById);
    //TODO get and set IMDB rating
    return movieRepository.save(movie);
  }

  public List<Movie> getAllMovies() {
    //TODO if imdb_last_updated > 1day -> get and set IMDB rating
    return movieRepository.findAll();
  }

  public Movie getMovieById(Long id) {
    //TODO if imdb_last_updated > 1day -> get and set IMDB rating
    return movieRepository.findById(id).orElse(new Movie());
  }

  public Movie editMovie(MovieDTO newMovie) {
    Movie movie = movieRepository.findById(newMovie.getId()).orElse(new Movie());
    Language languageById = languageRepository.findById(newMovie.getLanguage_id()).orElse(new Language());
    movie.updateValues(newMovie, languageById);
    //TODO get and set IMDB rating
    movieRepository.save(movie);
    return movie;
  }

  public Movie deleteMovie(Long id) {
    Movie movie = movieRepository.findById(id).orElse(new Movie());
    movieRepository.delete(movie);
    return movie;
  }

  public Movie rateMovie(MovieRatingDTO movieRatingDTO) {
    Movie movie = movieRepository.findById(movieRatingDTO.getMovie_id()).orElse(new Movie());
    MovieRating movieRating = new MovieRating(movieRatingDTO, movie);
    movieRatingRepository.save(movieRating);
    List<MovieRating> allMovieRatingsByMovieId = movieRatingRepository.findByMovieId(movieRatingDTO.getMovie_id());
    movie.updateUserRating(averageRating(allMovieRatingsByMovieId));
    return movieRepository.save(movie);
  }

  public Movie deleteRatingByMovieRatingId(Long movie_id, Long movie_rating_id) {
    Movie movie = movieRepository.findById(movie_id).orElse(new Movie());
    MovieRating movieRating = movieRatingRepository.findById(movie_rating_id).orElse(new MovieRating());
    movieRatingRepository.delete(movieRating);
    List<MovieRating> allMovieRatingsByMovieId = movieRatingRepository.findByMovieId(movie_id);
    movie.updateUserRating(averageRating(allMovieRatingsByMovieId));
    return movieRepository.save(movie);
  }

  public List<MovieRating> getAllMovieRatings(Long movie_id) {
    return movieRatingRepository.findByMovieId(movie_id);
  }

  private double averageRating(List<MovieRating> movieRatings) {
    return movieRatings
      .stream()
      .mapToDouble(MovieRating::getRating)
      .average()
      .orElse(0.0);
  }
}
