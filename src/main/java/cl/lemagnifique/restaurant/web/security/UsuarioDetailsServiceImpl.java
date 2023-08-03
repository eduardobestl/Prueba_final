package cl.lemagnifique.restaurant.web.security;

import awakelab.g6.grupal.model.persistence.entity.Usuario;
import awakelab.g6.grupal.model.persistence.repository.AdministrativoRepository;
import awakelab.g6.grupal.model.persistence.repository.ClienteRepository;
import awakelab.g6.grupal.model.persistence.repository.ProfesionalRepository;
import awakelab.g6.grupal.model.persistence.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UsuarioDetailsServiceImpl implements UserDetailsService {

  private final UsuarioRepository repository;
  private final ClienteRepository repositoryCliente;
  private final AdministrativoRepository repositoryAdministrativo;
  private final ProfesionalRepository repositoryProfesional;
  public UsuarioDetailsServiceImpl(UsuarioRepository repository, ClienteRepository repositoryCliente, AdministrativoRepository repositoryAdministrativo, ProfesionalRepository repositoryProfesional) {
    this.repository = repository;
    this.repositoryCliente = repositoryCliente;
    this.repositoryAdministrativo = repositoryAdministrativo;
    this.repositoryProfesional = repositoryProfesional;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Usuario> user = repository.findByUsername(username);
    if (user.isPresent()){
      return new MyUsuarioDetails(user.get(),repository, repositoryCliente,
              repositoryAdministrativo,  repositoryProfesional);
    }

    throw new UsernameNotFoundException("El usuario no existe!");
  }
}
