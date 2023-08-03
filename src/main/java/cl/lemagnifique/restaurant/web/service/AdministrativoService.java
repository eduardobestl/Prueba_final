package cl.lemagnifique.restaurant.web.service;

import awakelab.g6.grupal.model.domain.dto.Administrative;

import java.util.List;
import java.util.Optional;

public interface AdministrativoService {
Optional<List<Administrative>> findAll();
Optional<Administrative> findById(int id);
Optional<Administrative> create(Administrative administrative);
  Optional<Administrative> update(Administrative administrative);
}
