package com.ufostyle.creditservice.repositories;

import com.ufostyle.creditservice.entities.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CreditRepository extends ReactiveMongoRepository<Credit, String> {

  Flux<Credit> findCreditsByCustomerId(String id);
}
