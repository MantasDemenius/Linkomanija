package com.linkomanija.backend.database;

import com.linkomanija.backend.dto.MovieDTO;
import com.linkomanija.backend.repository.GenreRepository;
import com.linkomanija.backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static java.util.Arrays.asList;

@Component
public class DataPopulation {

  private MovieRepository movieRepository;
  private GenreRepository genreRepository;

  @Autowired
  public DataPopulation(MovieRepository movieRepository, GenreRepository genreRepository) {
    this.movieRepository = movieRepository;
    this.genreRepository = genreRepository;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationEvent() throws URISyntaxException {
    final String baseUrl = "http://localhost:8080/api/";
    RestTemplate restTemplate = new RestTemplate();

    //ADD MOVIES
    movieRepository.deleteAll();

    URI addMovie = new URI(baseUrl + "movie");
    MovieDTO movie1 = new MovieDTO(
      "Titanic",
      "Movie about ships",
      "tt0120338",
      (long)1,
      "V",
      asList((long)1 ,(long)2));

    MovieDTO movie2 = new MovieDTO(
      "The fast and furious",
      "Movie about fast cards",
      "tt0232500",
      (long)2,
      "N-13",
      asList((long)3 ,(long)4));

    MovieDTO movie3 = new MovieDTO(
      "SAW",
      "Movie about saws",
      "tt0387564",
      (long)3,
      "N-16",
      asList((long)5 ,(long)6));

    MovieDTO movie4 = new MovieDTO(
      "Avatar",
      "Movie about avatars",
      "tt0499549",
      (long)2,
      "V",
      asList((long)7 ,(long)8));

    MovieDTO movie5 = new MovieDTO(
      "Joker",
      "Movie about jokers",
      "tt7286456",
      (long)1,
      "N-16",
      asList((long)9 ,(long)10, (long)11));

    ResponseEntity<String> result = restTemplate.postForEntity(addMovie, movie1, String.class);
    ResponseEntity<String> result1 = restTemplate.postForEntity(addMovie, movie2, String.class);
    ResponseEntity<String> result2 = restTemplate.postForEntity(addMovie, movie3, String.class);
    ResponseEntity<String> result3 = restTemplate.postForEntity(addMovie, movie4, String.class);
    ResponseEntity<String> result4 = restTemplate.postForEntity(addMovie, movie5, String.class);
  }
}
