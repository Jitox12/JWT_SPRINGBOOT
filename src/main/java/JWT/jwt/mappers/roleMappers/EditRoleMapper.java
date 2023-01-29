package JWT.jwt.mappers.roleMappers;


import JWT.jwt.dto.roleDto.EditRoleDto;
import JWT.jwt.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EditRoleMapper {
    EditRoleMapper INSTANCE = Mappers.getMapper(EditRoleMapper.class);

    @Mapping(source = "roleId", target = "roleIdDto")
    @Mapping(source = "role", target = "roleDto")
    EditRoleDto roleEntityToEditRoleDto(RoleEntity role);
}