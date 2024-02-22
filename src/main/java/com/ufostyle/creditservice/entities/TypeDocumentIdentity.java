package com.ufostyle.creditservice.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TypeDocumentIdentity {

  private String id;
  private String description;
}
