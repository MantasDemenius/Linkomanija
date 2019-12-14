package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.MovieHall;
import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.service.MovieHallService;
import com.linkomanija.backend.service.UserEmployeeService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/movieHall")
public class MovieHallController {
  private MovieHallService movieHallService;

  public MovieHallController(MovieHallService movieHallService) {
    this.movieHallService = movieHallService;
  }

  @GetMapping(value = "/{id}")
  public MovieHall getMovieHall(@PathVariable(value = "id") Long id) {
    return movieHallService.getHall(id);
  }

  @PostMapping()
  public MovieHall addHall(@RequestBody MovieHall movieHall) {
    return movieHallService.save(movieHall);
  }

  @PostMapping(value = "/edit")
  public int editHall(@RequestBody MovieHall movieHall) {
    return movieHallService.edit(movieHall);
  }
}
