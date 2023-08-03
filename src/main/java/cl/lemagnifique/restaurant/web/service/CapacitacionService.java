package cl.lemagnifique.restaurant.web.service;

import awakelab.g6.grupal.model.domain.dto.Training;

import java.util.List;
import java.util.Optional;

public interface CapacitacionService {
Optional<List<Training>> findAll();
Optional<Training> findById(int id);
Optional<Training> create(Training training);
}
