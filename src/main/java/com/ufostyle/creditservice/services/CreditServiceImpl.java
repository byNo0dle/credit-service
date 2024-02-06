package com.ufostyle.creditservice.services;

import com.ufostyle.creditservice.entities.Credit;
import com.ufostyle.creditservice.models.*;
import com.ufostyle.creditservice.repositories.CreditRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CreditServiceImpl implements CreditService {

  Logger log = LoggerFactory.getLogger(CreditServiceImpl.class);

  @Autowired
  CreditRepository creditRepository;

  @Autowired
  RestTemplate restTemplate;

  @Value("${api.customer-service.uri}")
  private String customerService;

  @Value("${api.movementCredit-service.uri}")
  private String movementCreditService;

  @Value("${api.product-service.uri}")
  private String productService;

  @Override
  public Flux<Credit> findAll() {
    return creditRepository.findAll();
  }

  @Override
  public Mono<Credit> findById(String idCredit) {
    return creditRepository.findById(idCredit);
  }

  @Override
  public Mono<Credit> save(Credit credit) {
    return creditRepository.insert(credit);
  }

  @Override
  public Mono<Credit> update(Credit credit) {
    return creditRepository.save(credit);
  }

  @Override
  public Mono<Void> delete(String idCredit) {
    return creditRepository.deleteById(idCredit);
  }

  @Override
  public Map<String, Object> registerAccountCredit(Credit credit) {
    Map<String, Object> hashMap = new HashMap<String, Object>();
    boolean isValid = true;
    Product product = null;
    if (this.findByIdProduct(credit.getIdProduct()) != null) {
      product = this.findByIdProduct(credit.getIdProduct());
      if (product.getTypeProduct().equals("Pasivos")) {
        hashMap.put("Product", "El producto no es un activo para registrarse como crédito.");
        isValid = false;
      }
    } else {
      hashMap.put("Product", "Producto no encontrado.");
      isValid = false;
    }
    Customer customer = this.findByIdCustomer(credit.getIdCustomer());
    if (customer != null) {
      if (customer.getTypeCustomer().equals("Bussiness")) {
        hashMap.put("Product", "El cliente no puede tener una cuenta de credito.");
        isValid = false;
      }
    } else {
      hashMap.put("Customer", "El Cliente no existe.");
      isValid = false;
    }
    if (isValid) {
      this.save(credit).map(e->{

        return  Mono.just(hashMap);
      }).subscribe();
      hashMap.put("Credit", credit);
      return hashMap;
    }
    log.info(hashMap.toString());
    return hashMap;
  }

  @Override
  public Product findByIdProduct(String idProduct) {
    ResponseEntity<Product> responseGet = restTemplate.exchange(productService + "/" + idProduct, HttpMethod.GET,
        null, new ParameterizedTypeReference<Product>() {
        });
    if (responseGet.getStatusCode() == HttpStatus.OK) {
      return responseGet.getBody();
    } else {
      return null;
    }
  }

  @Override
  public Customer findByIdCustomer(String idCustomer) {
    log.info(customerService + "/" + idCustomer);
    ResponseEntity<Customer> responseGet = restTemplate.exchange(customerService + "/" + idCustomer, HttpMethod.GET,
        null, new ParameterizedTypeReference<Customer>() {
        });
    if (responseGet.getStatusCode() == HttpStatus.OK) {
      return responseGet.getBody();
    } else {
      return null;
    }
  }

  @Override
  public Flux<MovementCredit> consultMovements(String idCredit) {
    ResponseEntity<List<MovementCredit>> responseGet = restTemplate.exchange(movementCreditService, HttpMethod.GET,
        null, new ParameterizedTypeReference<List<MovementCredit>>() {
        });
    List<MovementCredit> list;
    if (responseGet.getStatusCode() == HttpStatus.OK) {
      list = responseGet.getBody();
      return Flux.fromIterable(list).filter(movementCredit -> movementCredit.getIdCredit() == idCredit);
    } else {
      return Flux.empty();
    }
  }
}
