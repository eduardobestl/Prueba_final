package cl.lemagnifique.restaurant.model.persistence.mapper;


import awakelab.g6.grupal.model.domain.dto.CheckList;
import awakelab.g6.grupal.model.persistence.entity.ListaChequeo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {VisitMapper.class})
public interface CheckListMapper {
  @Mappings({
          @Mapping(source ="id", target ="id"),
          @Mapping(source ="visita", target ="visit"),
          @Mapping(source ="detalle", target ="detail"),
          @Mapping(source ="estado", target ="status"),

  })
  CheckList toCheckList(ListaChequeo listaChequeo);
  List<CheckList> toCheckLists(List<ListaChequeo> listaChequeos);
  @InheritInverseConfiguration
  ListaChequeo toListaChequeo(CheckList checkList);
}
