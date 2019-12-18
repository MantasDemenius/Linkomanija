package com.linkomanija.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Date;

public class TimetableDTO {
  private Long id;
  private Date attending_date;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private Timestamp timetable_start;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private Timestamp timetable_end;
  private String comment;
  private Long user_employee_id;

  public TimetableDTO(Date attending_date, Date timetable_start, Date timetable_end, String comment, Long user_employee_id) {
    this.attending_date = attending_date;
    this.timetable_start = new Timestamp(timetable_start.getTime());
    this.timetable_end = new Timestamp(timetable_end.getTime());
    this.comment = comment;
    this.user_employee_id = user_employee_id;
  }

  public Long getId() {
    return id;
  }

  public Date getAttending_date() {
    return attending_date;
  }

  public Timestamp getTimetable_start() {
    return timetable_start;
  }

  public Timestamp getTimetable_end() {
    return timetable_end;
  }

  public String getComment() {
    return comment;
  }

  public Long getUser_employee_id() {
    return user_employee_id;
  }
}
