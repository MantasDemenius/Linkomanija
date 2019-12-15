package com.linkomanija.backend.domain;

import com.linkomanija.backend.dto.TimetableDTO;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "timetable")
public class Timetable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Date attending_date;
  private Timestamp timetable_start;
  private Timestamp timetable_end;
  private String comment;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_employee_id")
  private UserEmployee userEmployee;

  public Timetable(TimetableDTO timetableDTO, UserEmployee userEmployee) {
    this.id = timetableDTO.getId();
    this.attending_date = timetableDTO.getAttending_date();
    this.timetable_start = timetableDTO.getTimetable_start();
    this.timetable_end = timetableDTO.getTimetable_end();
    this.comment = timetableDTO.getComment();
    this.userEmployee = userEmployee;
  }

  public Timetable() {}

  public void updateTimetable(TimetableDTO timetableDTO) {
    this.id = timetableDTO.getId();
    this.attending_date = timetableDTO.getAttending_date();
    this.timetable_start = timetableDTO.getTimetable_start();
    this.timetable_end = timetableDTO.getTimetable_end();
    this.comment = timetableDTO.getComment();
  }
}
