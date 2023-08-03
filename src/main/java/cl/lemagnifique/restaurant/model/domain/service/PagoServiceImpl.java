package cl.lemagnifique.restaurant.model.domain.service;

import awakelab.g6.grupal.model.domain.dto.Pay;
import awakelab.g6.grupal.model.persistence.mapper.PayMapper;
import awakelab.g6.grupal.model.persistence.repository.PagoRepository;
import awakelab.g6.grupal.web.service.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class PagoServiceImpl implements PagoService {
    private final PagoRepository repository;
    private final PayMapper mapper;

    public PagoServiceImpl(PagoRepository repository, PayMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Pay>> findAll() {
        return Optional.of(mapper.toPays(repository.findAll()));    }

    @Override
    public Optional<Pay> findById(int id) {
        return repository.findById(id).map(mapper::toPay);
    }

    @Override
    public Optional<Pay> create(Pay pay) {
        return Optional.of(mapper.toPay(repository.save(mapper.toPago(pay))));
    }
}
