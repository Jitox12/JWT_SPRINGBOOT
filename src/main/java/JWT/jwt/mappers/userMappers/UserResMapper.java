package JWT.jwt.mappers.userMappers;

import JWT.jwt.dto.userDto.UserResponseDto;
import JWT.jwt.entities.RoleEntity;
import JWT.jwt.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserResMapper {
    UserResMapper INSTANCE = Mappers.getMapper( UserResMapper.class );

    default String RoleToRoleName(RoleEntity role){
        return role.getRole();
    }
    @Mapping(source = "userName", target = "userNameDto" )
    @Mapping(source = "userLastName", target = "userLastNameDto" )
    @Mapping(source = "email", target = "emailDto" )
    @Mapping(source = "role", target = "roleNameDto" )

    UserResponseDto userEntityToUserResDto(UserEntity user);
}