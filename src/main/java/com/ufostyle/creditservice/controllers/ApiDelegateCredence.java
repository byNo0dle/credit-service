package com.ufostyle.creditservice.controllers;

import com.ufostyle.creditservice.noodle.Credence;
import com.ufostyle.creditservice.services.CreditService;
import com.ufostyle.creditservice.ufo.CredenceApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ApiDelegateCredence implements CredenceApiDelegate {

  @Autowired
  private CreditService creditService;

  @Override
  public Mono<ResponseEntity<Credence>> saveCredence(Mono<Credence> credence, ServerWebExchange exchange) {
    return CredenceApiDelegate.super.saveCredence(credence, exchange);
  }
}
