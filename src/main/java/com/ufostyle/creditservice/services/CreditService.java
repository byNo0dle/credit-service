package com.ufostyle.creditservice.services;

import com.ufostyle.creditservice.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreditService {

  @Autowired
  CreditRepository creditRepository;
}
