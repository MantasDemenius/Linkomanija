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

  public Long getId() {
    return id;
  }

  public Date getSession_date() {
    return session_date;
  }

  public int getSession_count() {
    return session_count;
  }

  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  public String getSession_start() {
    return session_start;
  }

  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
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
