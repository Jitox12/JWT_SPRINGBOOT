package JWT.jwt.services.roleServices;

import JWT.jwt.dto.roleDto.RoleDto;
import JWT.jwt.dto.roleDto.RoleRequestDto;
import JWT.jwt.dto.roleDto.RoleResponseDto;
import JWT.jwt.entities.RoleEntity;

import java.io.IOException;
import java.util.List;

public interface RoleService {

    public RoleResponseDto findRoleByIdService(Integer roleId) throws IOException;
    public List<RoleDto> findRoleListService();

    public void createRoleService(RoleRequestDto roleReq);

    public void editRoleService(Integer roleId, RoleRequestDto roleReq);
}
