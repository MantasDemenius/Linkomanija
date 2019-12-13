package com.linkomanija.backend.controller;

import com.linkomanija.backend.domain.MovieHall;
import com.linkomanija.backend.domain.UserEmployee;
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

  @GetMapping()
  public MovieHall getMovieHall() {
    return new MovieHall();
  }

  @PostMapping(value = "/add")
  public MovieHall PlaceAdd(@RequestBody MovieHall movieHall) {
    return movieHall;
  }
}
