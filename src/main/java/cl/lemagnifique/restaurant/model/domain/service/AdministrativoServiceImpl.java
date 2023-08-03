package cl.lemagnifique.restaurant.model.domain.service;

import awakelab.g6.grupal.model.domain.dto.Administrative;
import awakelab.g6.grupal.model.persistence.mapper.AdministrativeMapper;
import awakelab.g6.grupal.model.persistence.repository.AdministrativoRepository;
import awakelab.g6.grupal.web.service.AdministrativoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativoServiceImpl implements AdministrativoService {

  private final AdministrativoRepository repository;
  private final AdministrativeMapper mapper;

  public AdministrativoServiceImpl(AdministrativoRepository repository,
                                   AdministrativeMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }


  @Override
  public Optional<List<Administrative>> findAll() {
    return Optional.of(mapper.toAdministratives(repository.findAll()));
  }
  @Override
  public Optional<Administrative> findById(int id) {
    return repository.findById(id).map(mapper::toAdministrative);
  }
  @Override
  public Optional<Administrative> create(Administrative administrative){
    return Optional.of(mapper.toAdministrative(repository.save(mapper.toAdministrativo(administrative))));
  }
  @Override
  public Optional<Administrative> update(Administrative administrative) {
    if (repository.existsById(administrative.getId())){
      return Optional.of(mapper.toAdministrative(repository.save(mapper.toAdministrativo(administrative))));
    }
    return Optional.of(new Administrative());
  }
}
