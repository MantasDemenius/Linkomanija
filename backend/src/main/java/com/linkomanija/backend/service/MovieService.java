package com.linkomanija.backend.service;

import com.linkomanija.backend.domain.*;
import com.linkomanija.backend.dto.MovieDTO;
import com.linkomanija.backend.dto.MovieRatingDTO;
import com.linkomanija.backend.omdb.ImdbMovie;
import com.linkomanija.backend.omdb.MovieFetch;
import com.linkomanija.backend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MovieService {

  private MovieRepository movieRepository;
  private LanguageRepository languageRepository;
  private MovieRatingRepository movieRatingRepository;
  private GenreRepository genreRepository;

  @Autowired
  public MovieService(GenreRepository genreRepository, MovieRepository movieRepository, LanguageRepository languageRepository, MovieRatingRepository movieRatingRepository) {
    this.movieRepository = movieRepository;
    this.languageRepository = languageRepository;
    this.movieRatingRepository = movieRatingRepository;
    this.genreRepository = genreRepository;
  }

  public Movie addMovie(MovieDTO movieDTO) throws IOException, ParseException {
    Language languageById = languageRepository.findById(movieDTO.getLanguage_id()).orElse(new Language());
    List<Long> genres = movieDTO.getGenre_list();
    List<Genre> genre_list = new ArrayList<>();
    for (Long genre : genres) {
      Genre temp = genreRepository.findById(genre).orElse(new Genre());
      genre_list.add(temp);
    }
    movieDTO.setGenres(genre_list);
    Movie movie = new Movie(movieDTO, languageById);
    ImdbMovie imdbMovie = MovieFetch.findMovieByCode(movieDTO.getImdb_code());
    movie.completeWithImdb(imdbMovie);
    return movieRepository.save(movie);
//    if (imdbMovie.valid()) {
//      movie.completeWithImdb(imdbMovie);
//      return movieRepository.save(movie);
//    }
//    return null;
  }

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  public Movie getMovieById(Long id) throws IOException, ParseException {
    Movie movie = movieRepository.findById(id).orElse(new Movie());
    updateRating(movie);
    return movie;
  }

  public Movie editMovie(MovieDTO newMovie) throws IOException, ParseException {
    Movie movie = movieRepository.findById(newMovie.getId()).orElse(new Movie());
    Language languageById = languageRepository.findById(newMovie.getLanguage_id()).orElse(new Language());
    List<Long> genres = newMovie.getGenre_list();
    List<Genre> genre_list = new ArrayList<>();
    for (Long genre : genres) {
      Genre temp = genreRepository.findById(genre).orElse(new Genre());
      genre_list.add(temp);
    }
    newMovie.setGenres(genre_list);
    movie.updateValues(newMovie, languageById);
    movie.completeWithImdb(MovieFetch.findMovieByCode(newMovie.getImdb_code()));
    return movieRepository.save(movie);
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

  private void updateRating(Movie movie) throws IOException, ParseException {
    Date last_updated = movie.getImdb_last_updated();
    long diffInMillies = new Date(System.currentTimeMillis()).getTime() - last_updated.getTime();
    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

    if (diff > 1) {
      double currentRating = MovieFetch.findMovieByCode(movie.getImdb_code()).getImdb_rating();
      movie.setImdbRating(currentRating);
      movieRepository.save(movie);
    }
  }
}
