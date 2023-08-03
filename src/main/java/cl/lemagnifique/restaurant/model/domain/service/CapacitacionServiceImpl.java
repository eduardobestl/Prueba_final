package cl.lemagnifique.restaurant.model.domain.service;

import awakelab.g6.grupal.model.domain.dto.Training;
import awakelab.g6.grupal.model.persistence.mapper.TrainingMapper;
import awakelab.g6.grupal.model.persistence.repository.CapacitacionRepository;
import awakelab.g6.grupal.web.service.CapacitacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapacitacionServiceImpl implements CapacitacionService {
    private final CapacitacionRepository repository;
    private final TrainingMapper mapper;

    public CapacitacionServiceImpl(CapacitacionRepository repository,
                                   TrainingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Training>> findAll() {
        return Optional.of(mapper.toTrainings(repository.findAll()));
    }
    @Override
    public Optional<Training> create(Training training){
        return Optional.of(mapper.toTraining(repository.save(mapper.toCapacitacion(training))));
    }
    @Override
    public Optional<Training> findById(int id) {
        return repository.findById(id).map(mapper::toTraining);
    }

}
