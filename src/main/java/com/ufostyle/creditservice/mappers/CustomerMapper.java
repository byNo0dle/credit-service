package com.ufostyle.creditservice.mappers;

import com.ufostyle.creditservice.entities.Customer;
import com.ufostyle.creditservice.noodle.Client;

public class CustomerMapper {

  public static Customer customer(Client client) {
    return Customer.builder()
        .id(client.getId())
        .firstname(client.getFirstName())
        .lastname(client.getLastName())
        .numberDocumentIdentity(client.getNumberDocumentIdentity())
        .email(client.getEmail())
        .build();
  }

  public static Client client(Customer customer) {
    Client client = new Client();
    client.setId(customer.getId());
    client.setFirstName(customer.getFirstname());
    client.setLastName(customer.getLastname());
    client.setNumberDocumentIdentity(customer.getNumberDocumentIdentity());
    client.setEmail(customer.getEmail());
    return client;
  }
}
