package com.ufostyle.creditservice.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditType {

  private String code;
  private String description;
  private Integer maintenanceCommission;
  private Integer amountCredits;
  private Boolean isActive;
}
