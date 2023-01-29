package JWT.jwt.mappers.userMappers;

import JWT.jwt.dto.userDto.GetUserDto;
import JWT.jwt.entities.RoleEntity;
import JWT.jwt.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GetUserMapper {
    GetUserMapper INSTANCE = Mappers.getMapper( GetUserMapper.class );

    default String RoleToRoleName(RoleEntity role){
        return role.getRole();
    }
    @Mapping(source = "userName", target = "userNameDto" )
    @Mapping(source = "userLastName", target = "userLastNameDto" )
    @Mapping(source = "email", target = "emailDto" )
    @Mapping(source = "role", target = "roleNameDto" )
    GetUserDto userEntityToGetUserDto(UserEntity user);
}