package com.ufostyle.creditservice.services;

import com.ufostyle.creditservice.entities.Credit;
import com.ufostyle.creditservice.models.Customer;
import com.ufostyle.creditservice.models.MovementCredit;
import com.ufostyle.creditservice.models.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface CreditService {

  Flux<Credit> findAll();

  Mono<Credit> findById(String idCredit);

  Mono<Credit> save(Credit credit);

  Mono<Credit> update(Credit credit);

  Mono<Void> delete(String idCredit);

  Map<String, Object> registerAccountCredit(Credit credit);

  Product findByIdProduct(String idProduct);

  Customer findByIdCustomer(String idCustomer);

  Flux<MovementCredit> consultMovements(String idCredit);
}
