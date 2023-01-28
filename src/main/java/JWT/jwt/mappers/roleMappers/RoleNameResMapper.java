package JWT.jwt.mappers.roleMappers;

import JWT.jwt.dto.roleDto.RoleDto;
import JWT.jwt.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleNameResMapper {

    RoleNameResMapper INSTANCE = Mappers.getMapper( RoleNameResMapper.class );

    @Mapping(source = "role", target = "roleDto")
    RoleDto roleEntityNameToRoleDto(RoleEntity role);

}
