package cl.lemagnifique.restaurant.model.persistence.mapper;

import awakelab.g6.grupal.model.domain.dto.Professional;
import awakelab.g6.grupal.model.persistence.entity.Profesional;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessionalMapper {
  @Mappings({
          @Mapping(source ="id", target ="id"),
          @Mapping(source ="run", target ="run"),
          @Mapping(source ="nombre", target ="name"),
          @Mapping(source ="apellido", target ="lastName"),
          @Mapping(source ="correo", target ="mail"),
          @Mapping(source ="telefono", target ="telephone"),
          @Mapping(source ="cargo", target ="position"),
          @Mapping(source ="usuarioId", target ="userId"),
  })
  Professional toProfessional(Profesional profesional);
  List<Professional> toProfessionals(List<Profesional> profesionals);
  @InheritInverseConfiguration
  Profesional toProfesional(Professional professional);
}
