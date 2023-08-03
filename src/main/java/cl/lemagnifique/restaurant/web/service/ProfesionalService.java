package cl.lemagnifique.restaurant.web.service;

import awakelab.g6.grupal.model.domain.dto.Professional;

import java.util.List;
import java.util.Optional;

public interface ProfesionalService {
Optional<List<Professional>> findAll();
Optional<Professional> findById(int id);
Optional<Professional> create(Professional professional);
Optional<Professional> update(Professional professional);
}
