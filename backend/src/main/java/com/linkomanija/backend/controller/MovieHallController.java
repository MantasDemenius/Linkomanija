package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.MovieHall;
import com.linkomanija.backend.dto.MovieHallDTO;
import com.linkomanija.backend.service.MovieHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/movieHall")
public class MovieHallController {

  @Autowired
  private MovieHallService movieHallService;

  @PostMapping(consumes = "application/json", produces = "application/json")
  public MovieHall addMovieHall(@RequestBody MovieHallDTO movieHallDTO) {
    return movieHallService.addMovieHall(movieHallDTO);
  }

  @PostMapping(value = "edit", produces = "application/json")
  public MovieHall editMovieHall(@RequestBody MovieHallDTO movieHallDTO) {
    return movieHallService.editMovieHall(movieHallDTO);
  }

  @DeleteMapping(value = "{id}", produces = "application/json")
  public MovieHall deleteMovieHall(@PathVariable(name = "id") Long id) {
    return movieHallService.deleteMovieHall(id);
  }

  @GetMapping(value = "{id}", produces = "application/json")
  public MovieHall getMovieHall(@PathVariable(name = "id") Long id) {
    return movieHallService.getMovieHallById(id);
  }

  @GetMapping(produces = "application/json")
  public List<MovieHall> getAllMovieHalls() {
    return movieHallService.getAllMovieHalls();
  }
}
