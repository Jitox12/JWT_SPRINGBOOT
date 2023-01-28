package JWT.jwt.mappers.userMappers;

import JWT.jwt.dto.userDto.UserRequestDto;
import JWT.jwt.dto.userDto.UserResponseDto;
import JWT.jwt.entities.RoleEntity;
import JWT.jwt.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserReqMapper {
    UserResMapper INSTANCE = Mappers.getMapper( UserResMapper.class );

    default String RoleToRoleName(RoleEntity role){
        return role.getRole();
    }
    @Mapping(source = "userNameDto", target = "userName" )
    @Mapping(source = "userLastNameDto", target = "userLastName" )
    @Mapping(source = "emailDto", target = "email" )

    UserEntity userReqDtoToUserEntity(UserRequestDto user);
}
