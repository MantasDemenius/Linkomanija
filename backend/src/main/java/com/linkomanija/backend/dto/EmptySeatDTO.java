package com.linkomanija.backend.dto;

import lombok.Data;

@Data
public class EmptySeatDTO {
    private int id;
    private int row;
    private int seat;

  public EmptySeatDTO(int row, int seat, int id) {
    this.row = row;
    this.seat = seat;
    this.id = id;
  }

  public int getRow() {
    return row;
  }

  public int getSeat() {
    return seat;
  }
}
