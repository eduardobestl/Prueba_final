package cl.lemagnifique.restaurant.model.domain.service;

import awakelab.g6.grupal.model.domain.dto.Customer;
import awakelab.g6.grupal.model.persistence.mapper.CustomerMapper;
import awakelab.g6.grupal.model.persistence.repository.ClienteRepository;
import awakelab.g6.grupal.web.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

  private final ClienteRepository repository;
  private final CustomerMapper mapper;

  public ClienteServiceImpl(ClienteRepository repository, CustomerMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }


  @Override
  public Optional<List<Customer>> findAll() {
    return Optional.of(mapper.toCustomers(repository.findAll()));
  }
  @Override
  public Optional<Customer> findById(int id) {
    return repository.findById(id).map(mapper::toCustomer);
  }
  @Override
  public Optional<Customer> create(Customer customer){
    return Optional.of(mapper.toCustomer(repository.save(mapper.toCliente(customer))));
  }
  @Override
  public Optional<Customer> update(Customer customer) {
    if (repository.existsById(customer.getId())){
      return Optional.of(mapper.toCustomer(repository.save(mapper.toCliente(customer))));
    }
    return Optional.of(new Customer());
  }
}
