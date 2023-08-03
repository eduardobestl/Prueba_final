package cl.lemagnifique.restaurant.model.persistence.mapper;


import awakelab.g6.grupal.model.domain.dto.Pay;
import awakelab.g6.grupal.model.persistence.entity.Pago;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface PayMapper {
  @Mappings({
          @Mapping(source ="id", target ="id"),
          @Mapping(source ="fechaPago", target ="payDay"),
          @Mapping(source ="monto", target ="amount"),
          @Mapping(source ="cliente", target ="customer"),

  })
  Pay toPay(Pago pago);
  List<Pay> toPays(List<Pago> pago);
  @InheritInverseConfiguration
  Pago toPago(Pay pay);
}
