package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Visit;
import awakelab.g6.grupal.web.service.ClienteService;
import awakelab.g6.grupal.web.service.VisitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/visita")
public class VisitaRestController {
  private final VisitaService service;
  private final ClienteService clienteService;
  public VisitaRestController(VisitaService service, ClienteService clienteService){
    this.service = service;
    this.clienteService = clienteService;
  }
  @GetMapping
  public ResponseEntity<List<Visit>> findAll(){
    return service.findAll().map(visit -> new ResponseEntity<>(visit, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }



}
