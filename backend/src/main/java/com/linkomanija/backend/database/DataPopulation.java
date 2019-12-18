package com.linkomanija.backend.database;

import com.linkomanija.backend.domain.*;
import com.linkomanija.backend.dto.*;
import com.linkomanija.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.DateUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class DataPopulation {

  private MovieRepository movieRepository;
  private UserEmployeeRepository userEmployeeRepository;
  private TimetableRepository timetableRepository;
  private SessionRepository sessionRepository;
  private MovieRatingRepository movieRatingRepository;
  private UserClientRepository userClientRepository;

  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  private LanguageRepository languageRepository;

  @Autowired
  private MovieHallRepository movieHallRepository;

  @Autowired
  private UserAdminRepository userAdminRepository;

  @Autowired
  public DataPopulation(UserClientRepository userClientRepository, MovieRatingRepository movieRatingRepository, SessionRepository sessionRepository, TimetableRepository timetableRepository, MovieRepository movieRepository, UserEmployeeRepository userEmployeeRepository) {
    this.movieRepository = movieRepository;
    this.userEmployeeRepository = userEmployeeRepository;
    this.timetableRepository = timetableRepository;
    this.sessionRepository = sessionRepository;
    this.movieRatingRepository = movieRatingRepository;
    this.userClientRepository = userClientRepository;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationEvent() throws URISyntaxException {
    final String baseUrl = "http://localhost:8080/api/";
    RestTemplate restTemplate = new RestTemplate();

    //ADD MOVIES
    reservationRepository.deleteAll();
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
    movie1.setId((long)1);

    MovieDTO movie2 = new MovieDTO(
      "The fast and furious",
      "Movie about fast cards",
      "tt0232500",
      (long)2,
      "N-13",
      asList((long)3 ,(long)4));
    movie2.setId((long)2);

    MovieDTO movie3 = new MovieDTO(
      "SAW",
      "Movie about saws",
      "tt0387564",
      (long)3,
      "N-16",
      asList((long)5 ,(long)6));
    movie3.setId((long)3);

    MovieDTO movie4 = new MovieDTO(
      "Avatar",
      "Movie about avatars",
      "tt0499549",
      (long)2,
      "V",
      asList((long)7 ,(long)8));
    movie4.setId((long)4);

    MovieDTO movie5 = new MovieDTO(
      "Joker",
      "Movie about jokers",
      "tt7286456",
      (long)1,
      "N-16",
      asList((long)9 ,(long)10, (long)11));
    movie5.setId((long)5);

    restTemplate.postForEntity(addMovie, movie1, String.class);
    restTemplate.postForEntity(addMovie, movie2, String.class);
    restTemplate.postForEntity(addMovie, movie3, String.class);
    restTemplate.postForEntity(addMovie, movie4, String.class);
    restTemplate.postForEntity(addMovie, movie5, String.class);

    //ADD CLIENTS
    URI addClient = new URI(baseUrl + "user/client");
    userClientRepository.deleteAll();
    UserClient userClient = new UserClient(
      (long)1,
      "client1",
      "client",
      "linkomanija.isp@gmail.com",
      "Klientas1",
      "Jonaitis",
      DateUtils.create(1998,06,03).getTime(),
      "123456789"
    );
    userClientRepository.save(userClient);

    userClient = new UserClient(
      (long)2,
      "client2",
      "client",
      "linkomanija.isp@gmail.com",
      "Klientas2",
      "Petraitis",
      DateUtils.create(1998,06,03).getTime(),
      "123456789"
    );
    userClientRepository.save(userClient);

//    //CREATE SESSIONS
//    SessionDTO sessionDTO = new SessionDTO((long)1, DateUtils.create(2019,06,06).getTime(),"15:30", "17:30",
//      150,1.50,120,1,1, 1,2);
//    Language language = languageRepository.findById(sessionDTO.getLanguage_id()).orElse(new Language());
//    MovieHall movieHall = movieHallRepository.findById(sessionDTO.getMovie_hall_id()).orElse(new MovieHall());
//    Movie movie = movieRepository.findById(sessionDTO.getMovie_id()).orElse(new Movie());
//    Session session = new Session(sessionDTO, language, movie, movieHall);
//    sessionRepository.save(session);

    //ADD ADMIN
    userAdminRepository.deleteAll();
    UserAdmin userAdmin = new UserAdmin((long)1, "admin", "admin", "admin@admin.com", "admin", "admin", new Date(100), "123");
    userAdminRepository.save(userAdmin);

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
    employee1.setId((long)1);

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
    employee2.setId((long)2);
    restTemplate.postForEntity(addEmployee, employee1, String.class);
    restTemplate.postForEntity(addEmployee, employee2, String.class);

//    //CREATE TICKETS
//    ReservationDTO reservationDTO = new ReservationDTO((long)1,DateUtils.create(2019,05,03).getTime(), 5,
//      6, 2.5, new Timestamp(DateUtils.create(2019,05,03,15,30).getTimeInMillis()),
//      new Timestamp(DateUtils.create(2019,05,03,17,30).getTimeInMillis()), true,(long)1,(long)1);
//
//    ReservationDTO reservationDTO1 = new ReservationDTO((long)1,DateUtils.create(2019,05,03).getTime(), 7,
//      8, 2.5, new Timestamp(DateUtils.create(2019,05,03,15,30).getTimeInMillis()),
//      new Timestamp(DateUtils.create(2019,05,03,17,30).getTimeInMillis()), true,(long)2,(long)1);
//    Reservation reservation1 = new Reservation(reservationDTO, userClientRepository.findById((long)1).orElse(new UserClient()), sessionRepository.findById((long)1).orElse(new Session()));
//    Reservation reservation2 = new Reservation(reservationDTO1, userClientRepository.findById((long)2).orElse(new UserClient()), sessionRepository.findById((long)1).orElse(new Session()));
//    reservationRepository.save(reservation1);
//    reservationRepository.save(reservation2);

    //ADD TIMETABLES
    URI addTimetable = new URI(baseUrl + "timetable");
    timetableRepository.deleteAll();
    Long employeeId1 = userEmployeeRepository.findByUsername("Darbuotojas1").getId();
    Long employeeId2 = userEmployeeRepository.findByUsername("Darbuotojas2").getId();

    Date attendingDate = DateUtils.create(2019, 10, 1).getTime();
    Calendar start = DateUtils.create(2010,10,1,10,0);
    Calendar end = DateUtils.create(2010,10,1,18,30);

    List<TimetableDTO> timetables1 = new ArrayList<>();
    List<TimetableDTO> timetables2 = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      timetables1.add(new TimetableDTO(attendingDate, start.getTime(), end.getTime(), "No comments", employeeId1));
      timetables2.add(new TimetableDTO(attendingDate, start.getTime(), end.getTime(), "No comments", employeeId2));
      start.add(Calendar.DATE, 1);
      end.add(Calendar.DATE, 1);
    }

    for (int i = 0; i < 5; i++) {
      restTemplate.postForEntity(addTimetable, timetables1.get(i), String.class);
      restTemplate.postForEntity(addTimetable, timetables2.get(i), String.class);
    }
  }
}
