package cl.lemagnifique.restaurant.model.persistence.mapper;

import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.model.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  @Mappings({
          @Mapping(source ="id", target ="id"),
          @Mapping(source ="nombre", target ="name"),
          @Mapping(source ="username", target ="username"),
          @Mapping(source ="password", target ="password"),
  })
  User toUser(Usuario usuario);
  List<User> toUsers(List<Usuario> usuario);
  @InheritInverseConfiguration
  Usuario toUsuario(User usuario);
}
