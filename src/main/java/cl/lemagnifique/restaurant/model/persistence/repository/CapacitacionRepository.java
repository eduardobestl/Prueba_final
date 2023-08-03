package cl.lemagnifique.restaurant.model.persistence.repository;

import awakelab.g6.grupal.model.persistence.entity.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Integer> {
}
