package JWT.jwt.mappers.roleMappers;


import JWT.jwt.dto.roleDto.RoleRequestDto;
import JWT.jwt.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleReqMapper {
    RoleReqMapper INSTANCE = Mappers.getMapper( RoleReqMapper.class );

    @Mapping(source = "roleId", target = "roleIdDto")
    @Mapping(source = "role", target = "roleDto")

    RoleRequestDto roleEntityToRoleReqDto(RoleEntity role);
}