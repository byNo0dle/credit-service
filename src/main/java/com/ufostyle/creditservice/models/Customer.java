package com.ufostyle.creditservice.models;

import lombok.Data;

@Data
public class Customer {

  private String idCustomer;
  private String firstName;
  private String lastName;
  private String emailAddress;
  private String phoneNumber;
  private String homeAddress;
  private TypeCustomer typeCustomer;
  private TypeDocument typeDocument;
}
