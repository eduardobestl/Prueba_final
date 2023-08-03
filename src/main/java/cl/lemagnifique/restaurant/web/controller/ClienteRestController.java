package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Customer;
import awakelab.g6.grupal.web.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
  private final ClienteService service;

  public ClienteRestController(ClienteService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Customer>> findAll() {
    return service.findAll().map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  @PostMapping("/create")
  public ResponseEntity<Customer> create(@RequestBody Customer customer){
    return service.create(customer)
            .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }
  @PatchMapping("/update")
  public ResponseEntity<Customer> update(@RequestBody Customer customer){
    return service.update(customer)
            .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
