package com.ufostyle.creditservice.models;

import lombok.Data;

import java.util.Date;

@Data
public class MovementCredit {

  String idMovementCredit;
  Double amount;
  Date dateMovement;
  TypeMovementCredit typeMovementCredit;
  String idCredit;

  @Override
  public String toString() {
    return "MovementCredit [" +
        "idMovementCredit='" + idMovementCredit + '\'' +
        ", amount=" + amount +
        ", dateMovement=" + dateMovement +
        ", typeMovementCredit=" + typeMovementCredit +
        ", idCredit=" + idCredit +
        "]";
  }
}
