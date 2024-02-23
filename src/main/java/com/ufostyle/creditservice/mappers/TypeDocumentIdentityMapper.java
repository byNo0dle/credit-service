package com.ufostyle.creditservice.mappers;

import com.ufostyle.creditservice.entities.TypeDocumentIdentity;
import com.ufostyle.creditservice.noodle.IdentityDocumentType;

public class TypeDocumentIdentityMapper {

  public static TypeDocumentIdentity typeDocumentIdentity(IdentityDocumentType identityDocumentType) {
    return TypeDocumentIdentity.builder()
        .code(identityDocumentType.getCode())
        .description(identityDocumentType.getDescription())
        .build();
  }

  public static IdentityDocumentType identityDocumentType(TypeDocumentIdentity typeDocumentIdentity) {
    IdentityDocumentType identityDocumentType = new IdentityDocumentType();
    identityDocumentType.setCode(typeDocumentIdentity.getCode());
    identityDocumentType.setDescription(typeDocumentIdentity.getDescription());
    return null;
  }
}
