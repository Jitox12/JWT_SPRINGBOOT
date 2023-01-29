package JWT.jwt.mappers.roleMappers;


import JWT.jwt.dto.roleDto.CreateRoleDto;
import JWT.jwt.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateRoleMapper {
    CreateRoleMapper INSTANCE = Mappers.getMapper( CreateRoleMapper.class );

    @Mapping(source = "role", target = "roleDto")
    CreateRoleDto roleEntityToCreateRoleDto(RoleEntity role);
}