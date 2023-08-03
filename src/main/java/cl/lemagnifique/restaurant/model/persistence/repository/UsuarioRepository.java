package cl.lemagnifique.restaurant.model.persistence.repository;

import awakelab.g6.grupal.model.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
  Optional<Usuario> findByUsername(String username);
}
