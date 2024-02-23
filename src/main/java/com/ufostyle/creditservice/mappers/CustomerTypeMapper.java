package com.ufostyle.creditservice.mappers;

import com.ufostyle.creditservice.entities.CustomerType;
import com.ufostyle.creditservice.noodle.TypeCustomer;

public class CustomerTypeMapper {

  public static CustomerType customerType(TypeCustomer typeCustomer) {
    return CustomerType.builder()
        .id(typeCustomer.getId())
        .description(typeCustomer.getDescription())
        .build();
  }

  public static TypeCustomer typeCustomer(CustomerType customerType) {
    TypeCustomer typeCustomer = new TypeCustomer();
    typeCustomer.setId(customerType.getId());
    typeCustomer.setDescription(customerType.getDescription());
    return typeCustomer;
  }
}
