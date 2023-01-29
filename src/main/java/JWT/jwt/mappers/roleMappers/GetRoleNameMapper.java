package JWT.jwt.mappers.roleMappers;

import JWT.jwt.dto.roleDto.GetRoleNameDto;
import JWT.jwt.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GetRoleNameMapper {
    GetRoleNameMapper INSTANCE = Mappers.getMapper( GetRoleNameMapper.class );

    @Mapping(source = "role", target = "roleDto")
    GetRoleNameDto roleEntityNameToGetRoleNameDto(RoleEntity role);
}
