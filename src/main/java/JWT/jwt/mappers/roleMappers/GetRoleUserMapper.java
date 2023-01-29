package JWT.jwt.mappers.roleMappers;

import JWT.jwt.dto.roleDto.GetRoleDto;
import JWT.jwt.entities.RoleEntity;
import JWT.jwt.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface GetRoleUserMapper {
    GetRoleUserMapper INSTANCE = Mappers.getMapper( GetRoleUserMapper.class );

    List<String> UserToUserName(Set<UserEntity> user);
    default String UserToUserName(UserEntity user){
        return user.getUserName().concat(" "+ user.getUserLastName());
    }

    @Mapping(source = "role", target = "roleDto")
    @Mapping(source = "users", target = "userNameListDto")
    GetRoleDto roleEntityToGetRoleUserDto(RoleEntity role);
}