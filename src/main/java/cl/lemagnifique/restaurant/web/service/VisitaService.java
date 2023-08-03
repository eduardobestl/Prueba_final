package cl.lemagnifique.restaurant.web.service;

import awakelab.g6.grupal.model.domain.dto.Visit;

import java.util.List;
import java.util.Optional;
public interface VisitaService {
Optional<List<Visit>> findAll();
Optional<Visit> findById(int id);
Optional<Visit> create(Visit visit);
}
