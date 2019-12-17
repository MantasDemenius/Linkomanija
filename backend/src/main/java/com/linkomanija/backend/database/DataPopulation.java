package com.linkomanija.backend.database;

import com.linkomanija.backend.domain.MovieTheatre;
import com.linkomanija.backend.domain.UserEmployee;
import com.linkomanija.backend.dto.MovieDTO;
import com.linkomanija.backend.dto.TimetableDTO;
import com.linkomanija.backend.dto.UserEmployeeDTO;
import com.linkomanija.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.DateUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import static java.util.Arrays.asList;

@Component
public class DataPopulation {

  private MovieRepository movieRepository;
  private UserEmployeeRepository userEmployeeRepository;
  private TimetableRepository timetableRepository;
  private SessionRepository sessionRepository;
  private MovieRatingRepository movieRatingRepository;

  @Autowired
  public DataPopulation(MovieRatingRepository movieRatingRepository, SessionRepository sessionRepository, TimetableRepository timetableRepository, MovieRepository movieRepository, UserEmployeeRepository userEmployeeRepository) {
    this.movieRepository = movieRepository;
    this.userEmployeeRepository = userEmployeeRepository;
    this.timetableRepository = timetableRepository;
    this.sessionRepository = sessionRepository;
    this.movieRatingRepository = movieRatingRepository;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationEvent() throws URISyntaxException {
    final String baseUrl = "http://localhost:8080/api/";
    RestTemplate restTemplate = new RestTemplate();

    //ADD MOVIES
    sessionRepository.deleteAll();
    movieRatingRepository.deleteAll();
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

    restTemplate.postForEntity(addMovie, movie1, String.class);
    restTemplate.postForEntity(addMovie, movie2, String.class);
    restTemplate.postForEntity(addMovie, movie3, String.class);
    restTemplate.postForEntity(addMovie, movie4, String.class);
    restTemplate.postForEntity(addMovie, movie5, String.class);

    //ADD EMPLOYEES
    URI addEmployee = new URI(baseUrl + "user/employee");
    timetableRepository.deleteAll();
    userEmployeeRepository.deleteAll();
    UserEmployeeDTO employee1 = new UserEmployeeDTO(
      "Darbuotojas1",
      "employee",
      "linkomanija.isp@gmail.com",
      "Jonas",
      "Jonaitis",
      new Date(System.currentTimeMillis()),
      "861235329",
      (long)2
    );

    UserEmployeeDTO employee2 = new UserEmployeeDTO(
      "Darbuotojas2",
      "employee",
      "linkomanija.isp@gmail.com",
      "Petras",
      "Petraitis",
      new Date(System.currentTimeMillis()),
      "861235328",
      (long)1
    );
    restTemplate.postForEntity(addEmployee, employee1, String.class);
    restTemplate.postForEntity(addEmployee, employee2, String.class);

    //ADD TIMETABLES
    URI addTimetable = new URI(baseUrl + "timetable");
    timetableRepository.deleteAll();
    Long employeeId1 = userEmployeeRepository.findByUsername("Darbuotojas1").getId();
    Long employeeId2 = userEmployeeRepository.findByUsername("Darbuotojas2").getId();

    Date attendingDate = new Date(2019, Calendar.NOVEMBER,1);
    Timestamp start = new Timestamp(2010, 10, 1, 10,0,0,0);
    Timestamp end = new Timestamp(2010, 10, 1, 18,30,0,0);

    TimetableDTO timetable1 = new TimetableDTO(attendingDate, start, end, "No comments", employeeId1);

    start.setDate(2);
    end.setDate(2);
    start.setHours(11);
    end.setHours(17);
    TimetableDTO timetable2 = new TimetableDTO(attendingDate, start, end, "No comments", employeeId1);

    start.setDate(3);
    end.setDate(3);
    start.setHours(9);
    end.setHours(20);
    TimetableDTO timetable3 = new TimetableDTO(attendingDate, start, end, "No comments", employeeId1);

    start.setDate(4);
    end.setDate(4);
    start.setHours(7);
    end.setHours(20);
    TimetableDTO timetable4 = new TimetableDTO(attendingDate, start, end, "No comments", employeeId1);

    start.setDate(5);
    end.setDate(5);
    start.setHours(8);
    end.setHours(21);
    TimetableDTO timetable5 = new TimetableDTO(attendingDate, start, end, "No comments", employeeId1);

    //

    timetable1 = new TimetableDTO(attendingDate, start, end, "No comments", employeeId2);

    start.setDate(2);
    end.setDate(2);
    start.setHours(11);
    end.setHours(17);
    timetable2 = new TimetableDTO(attendingDate, start, end, "No comments", employeeId2);

    start.setDate(3);
    end.setDate(3);
    start.setHours(9);
    end.setHours(20);
    timetable3 = new TimetableDTO(attendingDate, start, end, "No comments", employeeId2);

    start.setDate(4);
    end.setDate(4);
    start.setHours(7);
    end.setHours(20);
    timetable4 = new TimetableDTO(attendingDate, start, end, "No comments", employeeId2);

    start.setDate(5);
    end.setDate(5);
    start.setHours(8);
    end.setHours(21);
    timetable5 = new TimetableDTO(attendingDate, start, end, "No comments", employeeId2);

    restTemplate.postForEntity(addTimetable, timetable1, String.class);
    restTemplate.postForEntity(addTimetable, timetable2, String.class);
    restTemplate.postForEntity(addTimetable, timetable3, String.class);
    restTemplate.postForEntity(addTimetable, timetable4, String.class);
    restTemplate.postForEntity(addTimetable, timetable5, String.class);
  }
}
