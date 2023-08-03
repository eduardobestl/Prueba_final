package cl.lemagnifique.restaurant.web.security;

import awakelab.g6.grupal.model.persistence.entity.Usuario;
import awakelab.g6.grupal.model.persistence.repository.AdministrativoRepository;
import awakelab.g6.grupal.model.persistence.repository.ClienteRepository;
import awakelab.g6.grupal.model.persistence.repository.ProfesionalRepository;
import awakelab.g6.grupal.model.persistence.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class MyUsuarioDetails implements UserDetails {

  private final Usuario user;
  private final UsuarioRepository repository;
  private final ClienteRepository repositoryCliente;
  private final AdministrativoRepository repositoryAdministrativo;
  private final ProfesionalRepository repositoryProfesional;

  public MyUsuarioDetails(Usuario user, UsuarioRepository repository, ClienteRepository repositoryCliente, AdministrativoRepository repositoryAdministrativo, ProfesionalRepository repositoryProfesional) {
    this.user = user;
    this.repository = repository;
    this.repositoryCliente = repositoryCliente;
    this.repositoryAdministrativo = repositoryAdministrativo;
    this.repositoryProfesional = repositoryProfesional;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    String rol="";
    if (repositoryAdministrativo.existsByUsuarioId(user.getId()))
    {
      rol = "ADMINISTRATIVO";
      System.out.println(rol);
    }
    if (repositoryCliente.existsByUsuarioId(user.getId()))
    {
      rol = "CLIENTE";
      System.out.println(rol);
    }
    if (repositoryProfesional.existsByUsuarioId(user.getId()))
    {
      rol = "PROFESIONAL";
      System.out.println(rol);
    }
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(rol);
    return List.of(authority);
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}