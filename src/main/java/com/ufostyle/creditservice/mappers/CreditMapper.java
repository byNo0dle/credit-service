package com.ufostyle.creditservice.mappers;

import com.ufostyle.creditservice.entities.Credit;
import com.ufostyle.creditservice.noodle.Client;
import com.ufostyle.creditservice.noodle.Credence;

import java.time.LocalDate;

public class CreditMapper {

  public static Credit credit(Credence credence) {
    return Credit.builder()
        .id(credence.getId())
        .cardNumber(credence.getCardNumber())
        .cvv(credence.getCvv())
        .month(credence.getMonth())
        .year(credence.getYear())
        .creditLimit(credence.getCreditLimit())
        .paymentDate(credence.getPaymentDate())
        .isActive(credence.getIsActive())
        .amountAvailable(credence.getAmountAvailable())
        .amountConsumed(credence.getAmountConsumed())
        .customer(CustomerMapper.customer(credence.getClient()))
        .creditType(CreditTypeMapper.creditType(credence.getTypeCredit()))
        .build();
  }

  public static Credence credence(Credit credit) {
    Credence credence = new Credence();
    credence.setId(credit.getId());
    credence.setCardNumber(credit.getCardNumber());
    credence.setCvv(credit.getCvv());
    credence.setMonth(credit.getMonth());
    credence.setYear(credit.getYear());
    credence.setCreditLimit(credit.getCreditLimit());
    credence.setIsActive(credit.getIsActive());
    credence.setAmountAvailable(credit.getAmountAvailable());
    credence.setAmountConsumed(credit.getAmountConsumed());
    credence.setClient(CustomerMapper.client(credit.getCustomer()));
    credence.setTypeCredit(CreditTypeMapper.typeCredit(credit.getCreditType()));
    return credence;
  }
}
