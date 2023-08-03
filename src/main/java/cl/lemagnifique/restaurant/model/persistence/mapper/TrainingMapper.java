package cl.lemagnifique.restaurant.model.persistence.mapper;

import awakelab.g6.grupal.model.domain.dto.Training;
import awakelab.g6.grupal.model.persistence.entity.Capacitacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface TrainingMapper {
  @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "nombre", target = "name"),
          @Mapping(source = "lugar", target = "place"),
          @Mapping(source = "fecha", target = "date"),
          @Mapping(source = "hora", target = "time"),
          @Mapping(source = "detalle", target = "detail"),
          @Mapping(source = "duracion", target = "duration"),
          @Mapping(source = "cantidad", target = "quantity"),
          @Mapping(source = "cliente", target = "customer"),
  })
  Training toTraining(Capacitacion capacitacion);
  List<Training> toTrainings(List<Capacitacion> capacitacion);
  @InheritInverseConfiguration
  Capacitacion toCapacitacion(Training training);
}
