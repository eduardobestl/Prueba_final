package cl.lemagnifique.restaurant.model.domain.service;

import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.model.persistence.mapper.UserMapper;
import awakelab.g6.grupal.model.persistence.repository.UsuarioRepository;
import awakelab.g6.grupal.web.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioRepository repository;
  private final UserMapper mapper;

  public UsuarioServiceImpl(UsuarioRepository repository, UserMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }


  @Override
  public Optional<List<User>> findAll() {
    return Optional.of(mapper.toUsers(repository.findAll()));
  }
  @Override
  public Optional<User> findById(int id) {
    return repository.findById(id).map(mapper::toUser);
  }
  @Override
  public Optional<User> create(User user){
    return Optional.of(mapper.toUser(repository.save(mapper.toUsuario(user))));
  }
  @Override
  public Optional<User> update(User user) {
    if (repository.existsById(user.getId())){
      return Optional.of(mapper.toUser(repository.save(mapper.toUsuario(user))));
    }
    return Optional.of(new User());
  }

}
