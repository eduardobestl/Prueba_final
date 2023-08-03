package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Training;
import awakelab.g6.grupal.web.service.CapacitacionService;
import awakelab.g6.grupal.web.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/capacitacion")
public class CapacitacionRestController {
  private final CapacitacionService service;
  private final ClienteService serviceCliente;
  public CapacitacionRestController(CapacitacionService service,
                                    ClienteService serviceCliente){
    this.service = service;
    this.serviceCliente = serviceCliente;
  }
  @GetMapping
  public ResponseEntity<List<Training>> findAll(){
    return service.findAll().map(training -> new ResponseEntity<>(training, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/create")
  public ResponseEntity<Training> create(@RequestBody Training training){
    return service.create(training)
            .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }

}
