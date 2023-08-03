package cl.lemagnifique.restaurant.model.persistence.repository;

import awakelab.g6.grupal.model.persistence.entity.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional,
        Integer> {
  boolean existsByUsuarioId(int id);

}
