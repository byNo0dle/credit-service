package com.ufostyle.creditservice.mappers;

import com.ufostyle.creditservice.entities.CreditType;
import com.ufostyle.creditservice.noodle.TypeCredit;

public class CreditTypeMapper {

  public static CreditType creditType(TypeCredit typeCredit) {
    return CreditType.builder()
        .code(typeCredit.getCode())
        .description(typeCredit.getDescription())
        .maintenanceCommission(typeCredit.getMaintenanceCommission())
        .amountCredits(typeCredit.getAmountCredits())
        .isActive(typeCredit.getIsActive())
        .build();
  }

  public static TypeCredit typeCredit(CreditType creditType) {
    TypeCredit typeCredit = new TypeCredit();
    typeCredit.setCode(creditType.getCode());
    typeCredit.setDescription(creditType.getDescription());
    typeCredit.setMaintenanceCommission(creditType.getMaintenanceCommission());
    typeCredit.setAmountCredits(creditType.getAmountCredits());
    typeCredit.setIsActive(creditType.getIsActive());
    return typeCredit;
  }
}
