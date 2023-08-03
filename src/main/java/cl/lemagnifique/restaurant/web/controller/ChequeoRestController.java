package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.CheckList;
import awakelab.g6.grupal.web.service.ListaChequeoService;
import awakelab.g6.grupal.web.service.VisitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chequeo")
public class ChequeoRestController {
  private final ListaChequeoService service;
  private final VisitaService visitaService;
  public ChequeoRestController(ListaChequeoService service, VisitaService visitaService){
    this.service = service;
    this.visitaService = visitaService;
  }
  @GetMapping
  public ResponseEntity<List<CheckList>> findAll(){
    return service.findAll().map(checkList -> new ResponseEntity<>(checkList, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }



}
