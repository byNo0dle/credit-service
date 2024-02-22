package com.ufostyle.creditservice.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Customer {

  private String id ;
  private String firstname;
  private String lastname;
  private String numberDocumentIdentity;
  private String email;
  private CustomerType customerType;
  private TypeDocumentIdentity typeDocumentIdentity;
}
