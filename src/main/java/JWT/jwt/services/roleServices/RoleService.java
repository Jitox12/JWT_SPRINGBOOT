package JWT.jwt.services.roleServices;

import JWT.jwt.dto.roleDto.CreateRoleDto;
import JWT.jwt.dto.roleDto.EditRoleDto;
import JWT.jwt.dto.roleDto.GetRoleDto;
import JWT.jwt.dto.roleDto.GetRoleNameDto;

import java.util.List;

public interface RoleService {

    public GetRoleDto findRoleByIdService(Integer roleId);
    public  List<GetRoleNameDto> findRoleListService();

    public String createRoleService(CreateRoleDto createRoleReq);

    public String editRoleService(Integer roleId, EditRoleDto editRoleReq);
}
