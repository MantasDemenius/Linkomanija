package com.linkomanija.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SessionDTO {
  private Long id;
  private Date session_date;
  private String session_start;
  private String session_end;
  private int empty_spaces;
  private double price;
  private float length;
  private int session_count;
  private long language_id;
  private long movie_id;
  private long movie_hall_id;

  public SessionDTO(Long id, Date session_date, String session_start, String session_end, int empty_spaces, double price, float length, int session_count, long language_id, long movie_id, long movie_hall_id) {
    this.id = id;
    this.session_date = session_date;
    this.session_start = session_start;
    this.session_end = session_end;
    this.empty_spaces = empty_spaces;
    this.price = price;
    this.length = length;
    this.session_count = session_count;
    this.language_id = language_id;
    this.movie_id = movie_id;
    this.movie_hall_id = movie_hall_id;
  }

  public Long getId() {
    return id;
  }

  public Date getSession_date() {
    return session_date;
  }

  public int getSession_count() {
    return session_count;
  }

  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  public String getSession_start() {
    return session_start;
  }

  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  public String getSession_end() {
    return session_end;
  }

  public int getEmpty_spaces() {
    return empty_spaces;
  }

  public double getPrice() {
    return price;
  }

  public float getLength() {
    return length;
  }

  public long getLanguage_id() {
    return language_id;
  }

  public long getMovie_id() {
    return movie_id;
  }

  public long getMovie_hall_id() {
    return movie_hall_id;
  }

  public void setEmpty_spaces(int empty_spaces) {
    this.empty_spaces = empty_spaces;
  }

  public void setSession_end(String session_end) {
    this.session_end = session_end;
  }

  public void setLength(float length) {
    this.length = length;
  }
}
