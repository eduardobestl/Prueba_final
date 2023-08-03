package cl.lemagnifique.restaurant.web.service;

import awakelab.g6.grupal.model.domain.dto.Pay;

import java.util.List;
import java.util.Optional;

public interface PagoService {
Optional<List<Pay>> findAll();
Optional<Pay> findById(int id);
Optional<Pay> create(Pay pay);
}
