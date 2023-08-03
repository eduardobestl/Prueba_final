package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Professional;
import awakelab.g6.grupal.web.service.ProfesionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesional")
public class ProfesionalRestController {
  private final ProfesionalService service;

  public ProfesionalRestController(ProfesionalService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Professional>> findAll() {
    return service.findAll().map(professional -> new ResponseEntity<>(professional, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  @PostMapping("/create")
  public ResponseEntity<Professional> create(@RequestBody Professional professional){
    return service.create(professional)
            .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }
  @PatchMapping("/update")
  public ResponseEntity<Professional> update(@RequestBody Professional professional){
    return service.update(professional)
            .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
