package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Administrative;
import awakelab.g6.grupal.web.service.AdministrativoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrativo")
public class AdministrativoRestController {
  private final AdministrativoService service;

  public AdministrativoRestController(AdministrativoService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Administrative>> findAll() {
    return service.findAll().map(administrative -> new ResponseEntity<>(administrative,
                    HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  @PostMapping("/create")
  public ResponseEntity<Administrative> create(@RequestBody Administrative administrative){
    return service.create(administrative)
            .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }
  @PatchMapping("/update")
  public ResponseEntity<Administrative> update(@RequestBody Administrative administrative){
    return service.update(administrative)
            .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
