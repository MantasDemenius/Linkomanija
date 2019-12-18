package com.linkomanija.backend.dto;

import lombok.Data;

public class EmptySeatDTO {
    private int row;
    private int seat;

  public EmptySeatDTO(int row, int seat) {
    this.row = row;
    this.seat = seat;
  }

  public int getRow() {
    return row;
  }

  public int getSeat() {
    return seat;
  }
}
