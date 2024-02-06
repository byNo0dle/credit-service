package com.ufostyle.creditservice.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "credits")
public class Credit {

  @Id
  String idCredit;
  String idCustomer;
  String idProduct;
  Double amountCreditLimit;
}
