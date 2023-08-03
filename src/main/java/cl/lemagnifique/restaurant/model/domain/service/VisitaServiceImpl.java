package cl.lemagnifique.restaurant.model.domain.service;

import awakelab.g6.grupal.model.domain.dto.Visit;
import awakelab.g6.grupal.model.persistence.mapper.VisitMapper;
import awakelab.g6.grupal.model.persistence.repository.VisitaRepository;
import awakelab.g6.grupal.web.service.VisitaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VisitaServiceImpl implements VisitaService {
    private final VisitaRepository repository;
    private final VisitMapper mapper;

    public VisitaServiceImpl(VisitaRepository repository, VisitMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Visit>> findAll() {
        return Optional.of(mapper.toVisits(repository.findAll()));
    }

    @Override
    public Optional<Visit> findById(int id) {
        return repository.findById(id).map(mapper::toVisit);
    }

    @Override
    public Optional<Visit> create(Visit visit) {
        return Optional.empty();
    }
}
