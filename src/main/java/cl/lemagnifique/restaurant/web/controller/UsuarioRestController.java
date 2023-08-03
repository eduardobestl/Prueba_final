package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.web.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
  private final UsuarioService service;

  public UsuarioRestController(UsuarioService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    return service.findAll().map(user -> new ResponseEntity<>(user,
                    HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  @PostMapping("/create")
  public ResponseEntity<User> create(@RequestBody User user){
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return service.create(user)
            .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }
  @PatchMapping("/update")
  public ResponseEntity<User> update(@RequestBody User user){
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return service.update(user)
            .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
