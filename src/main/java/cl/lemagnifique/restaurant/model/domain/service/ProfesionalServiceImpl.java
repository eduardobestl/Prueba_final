package cl.lemagnifique.restaurant.model.domain.service;

import awakelab.g6.grupal.model.domain.dto.Professional;
import awakelab.g6.grupal.model.persistence.mapper.ProfessionalMapper;
import awakelab.g6.grupal.model.persistence.repository.ProfesionalRepository;
import awakelab.g6.grupal.web.service.ProfesionalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesionalServiceImpl implements ProfesionalService {

  private final ProfesionalRepository repository;
  private final ProfessionalMapper mapper;

  public ProfesionalServiceImpl(ProfesionalRepository repository,
                                ProfessionalMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }


  @Override
  public Optional<List<Professional>> findAll() {
    return Optional.of(mapper.toProfessionals(repository.findAll()));
  }
  @Override
  public Optional<Professional> findById(int id) {
    return repository.findById(id).map(mapper::toProfessional);
  }
  @Override
  public Optional<Professional> create(Professional customer){
    return Optional.of(mapper.toProfessional(repository.save(mapper.toProfesional(customer))));
  }
  @Override
  public Optional<Professional> update(Professional professional) {
    if (repository.existsById(professional.getId())){
      return Optional.of(mapper.toProfessional(repository.save(mapper.toProfesional(professional))));
    }
    return Optional.of(new Professional());
  }
}
