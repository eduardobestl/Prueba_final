package cl.lemagnifique.restaurant.model.domain.service;

import awakelab.g6.grupal.model.domain.dto.CheckList;
import awakelab.g6.grupal.model.persistence.mapper.CheckListMapper;
import awakelab.g6.grupal.model.persistence.repository.ListaChequeoRepository;
import awakelab.g6.grupal.web.service.ListaChequeoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ListaChequeoServiceImpl implements ListaChequeoService {

    private final ListaChequeoRepository repository;
    private final CheckListMapper mapper;

    public ListaChequeoServiceImpl(ListaChequeoRepository repository, CheckListMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<CheckList>> findAll() {
        return Optional.of(mapper.toCheckLists(repository.findAll()));
    }

    @Override
    public Optional<CheckList> findById(int id) {
        return repository.findById(id).map(mapper::toCheckList);
    }

    @Override
    public Optional<CheckList> create(CheckList checkList) {
        return Optional.empty();
    }
}
