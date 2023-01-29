package JWT.jwt.mappers.roleMappers;

import JWT.jwt.dto.roleDto.GetRoleByIdDto;
import JWT.jwt.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GetRoleByIdMapper {

    GetRoleByIdMapper INSTANCE = Mappers.getMapper( GetRoleByIdMapper.class );

    @Mapping(source = "role", target = "roleDto")
    @Mapping(source = "roleId", target = "roleIdDto")
    GetRoleByIdDto roleEntityNameToGetRoleByIdDto(RoleEntity role);

}
