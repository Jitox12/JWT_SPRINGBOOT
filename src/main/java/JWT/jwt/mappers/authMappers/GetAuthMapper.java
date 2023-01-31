package JWT.jwt.mappers.authMappers;

import JWT.jwt.dto.auth.AuthDto;
import JWT.jwt.entities.RoleEntity;
import JWT.jwt.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GetAuthMapper {

    GetAuthMapper INSTANCE = Mappers.getMapper( GetAuthMapper.class );

    default String RoleToRoleName(RoleEntity role){
        return role.getRole();
    }

    @Mapping(source = "userName", target = "userNameDto" )
    @Mapping(source = "userLastName", target = "userLastNameDto" )
    @Mapping(source = "email", target = "emailDto" )
    @Mapping(source = "role", target = "roleNameDto" )
    @Mapping(source = "password", target = "passwordDto" )

    AuthDto userEntityToUserJwtDto(UserEntity user);
}