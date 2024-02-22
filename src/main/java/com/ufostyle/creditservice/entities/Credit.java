package com.ufostyle.creditservice.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@Document(collection = "credits")
public class Credit {

  @Id
  private String id = UUID.randomUUID().toString();
  private String cardNumber;
  private Integer cvv;
  private Integer month;
  private Integer year;
  private Double creditLimit;
  private LocalDate paymentDate;
  private Boolean isActive;
  private Double amountAvailable;
  private Double amountConsumed;
  private Customer customer;
  private CreditType creditType;
}
