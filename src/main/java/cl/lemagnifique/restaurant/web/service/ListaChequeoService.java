package cl.lemagnifique.restaurant.web.service;

import awakelab.g6.grupal.model.domain.dto.CheckList;

import java.util.List;
import java.util.Optional;

public interface ListaChequeoService {
Optional<List<CheckList>> findAll();
Optional<CheckList> findById(int id);
Optional<CheckList> create(CheckList checkList);
}
