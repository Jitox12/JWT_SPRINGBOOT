package JWT.jwt.mappers.authMappers;

import JWT.jwt.dto.auth.AuthDto;
import JWT.jwt.entities.RoleEntity;
import JWT.jwt.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.management.relation.Role;

@Mapper(componentModel = "spring")
public interface GetUserJwtMapper {

    GetUserJwtMapper INSTANCE = Mappers.getMapper( GetUserJwtMapper.class );

    default Integer RoleToRoleId(RoleEntity role){
        return role.getRoleId();
    }

    @Mapping(source = "userName", target = "userNameDto" )
    @Mapping(source = "userLastName", target = "userLastNameDto" )
    @Mapping(source = "email", target = "emailDto" )
    @Mapping(source = "role", target = "roleIdDto" )
    @Mapping(source = "password", target = "passwordDto" )

    AuthDto userEntityToUserJwtDto(UserEntity user);
}