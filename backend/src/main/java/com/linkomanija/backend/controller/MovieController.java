package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.Movie;
import com.linkomanija.backend.dto.MovieDTO;
import com.linkomanija.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/movie")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @PostMapping(produces = "application/json")
  public Movie addMovie(@RequestBody MovieDTO movieDTO) {
    return movieService.addMovie(movieDTO);
  }

  @PostMapping(value = "/edit", produces = "application/json")
  public Movie editMovie(@RequestBody MovieDTO movieDTO) {
    return movieService.editMovie(movieDTO);
  }

  @DeleteMapping(value = "/{id}", produces = "application/json")
  public Movie deleteMovie(@PathVariable(name = "id") Long id) {
    return movieService.deleteMovie(id);
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public Movie getMovie(@PathVariable(name = "id") Long id) {
    return movieService.getMovieById(id);
  }

  @GetMapping(produces = "application/json")
  public List<Movie> getAllMovies() {
    return movieService.getAllMovies();
  }
}
