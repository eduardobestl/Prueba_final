package cl.lemagnifique.restaurant.model.persistence.mapper;

import awakelab.g6.grupal.model.domain.dto.Customer;
import awakelab.g6.grupal.model.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  @Mappings({
          @Mapping(source ="id", target ="id"),
          @Mapping(source ="rut", target ="rut"),
          @Mapping(source ="nombre", target ="name"),
          @Mapping(source ="apellido", target ="lastName"),
          @Mapping(source ="correo", target ="mail"),
          @Mapping(source ="telefono", target ="telephone"),
          @Mapping(source ="afp", target ="afp"),
          @Mapping(source ="sistemaSalud", target ="healthcare"),
          @Mapping(source ="direccion", target ="direction"),
          @Mapping(source ="comuna", target ="district"),
          @Mapping(source ="edad", target ="age"),
          @Mapping(source ="usuarioId", target ="userId"),
  })
  Customer toCustomer(Cliente cliente);
  List<Customer> toCustomers(List<Cliente> cliente);
  @InheritInverseConfiguration
  Cliente toCliente(Customer customer);
}
