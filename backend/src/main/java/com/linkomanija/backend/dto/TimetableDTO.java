package com.linkomanija.backend.dto;

import java.sql.Timestamp;
import java.util.Date;

public class TimetableDTO {
  private Long id;
  private Date attending_date;
  private Timestamp timetable_start;
  private Timestamp timetable_end;
  private String comment;
  private Long user_employee_id;

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
