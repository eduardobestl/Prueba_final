package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Pay;
import awakelab.g6.grupal.web.service.ClienteService;
import awakelab.g6.grupal.web.service.PagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pago")
public class PagoRestController {
  private final PagoService service;
  private final ClienteService clienteService;

  public PagoRestController(PagoService service, ClienteService clienteService) {
    this.service = service;
    this.clienteService = clienteService;
  }

  @GetMapping
  public ResponseEntity<List<Pay>> findAll(){
    return service.findAll().map(pay -> new ResponseEntity<>(pay, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/create")
  public ResponseEntity<Pay> create(@RequestBody Pay pay){
    return service.create(pay)
            .map(p-> new ResponseEntity<>(p, HttpStatus.CREATED))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }

}
