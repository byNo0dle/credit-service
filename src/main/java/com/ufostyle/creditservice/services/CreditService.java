package com.ufostyle.creditservice.services;

import com.ufostyle.creditservice.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreditService {

  @Autowired
  CreditRepository creditRepository;

  /*public Mono<Credence> save(Credence credence) {
    return creditRepository.save()
  }*/

  /*public Mono<Client> save(Client client) {
    log.info("--- Se creo un nuevo cliente: ---");
    return customerRepository.save(CustomerMapper.customer(client))
        .flatMap(customer1 -> Mono.just(CustomerMapper.client(customer1)));
  }*/
}
