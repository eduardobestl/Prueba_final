package cl.lemagnifique.restaurant.model.persistence.repository;

import awakelab.g6.grupal.model.persistence.entity.Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativoRepository extends JpaRepository<Administrativo,
        Integer> {
  boolean existsByUsuarioId(int id);
}
