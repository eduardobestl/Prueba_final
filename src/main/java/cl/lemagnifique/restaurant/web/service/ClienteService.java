package cl.lemagnifique.restaurant.web.service;

import awakelab.g6.grupal.model.domain.dto.Customer;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
Optional<List<Customer>> findAll();
Optional<Customer> findById(int id);
Optional<Customer> create(Customer customer);
  Optional<Customer> update(Customer customer);
}
