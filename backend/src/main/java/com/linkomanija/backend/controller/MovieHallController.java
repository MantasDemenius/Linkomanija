package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.MovieHall;
import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.service.MovieHallService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/movieHall")
public class MovieHallController {
  private MovieHallService movieHallService;

  @GetMapping()
  public MovieHall getMovieHall() {
    return new MovieHall();
  }

  @PostMapping(value = "/add")
  public MovieHall addHall(@RequestBody MovieHall movieHall) {
    return movieHallService.save(movieHall);
  }

  @PostMapping(value = "/edit")
  public int editHall(@RequestBody MovieHall movieHall) {
    return movieHallService.edit(movieHall);
  }
}
