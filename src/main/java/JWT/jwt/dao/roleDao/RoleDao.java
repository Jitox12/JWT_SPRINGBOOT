package JWT.jwt.dao.roleDao;

import JWT.jwt.dto.roleDto.CreateRoleDto;
import JWT.jwt.dto.roleDto.EditRoleDto;
import JWT.jwt.entities.RoleEntity;

import java.io.IOException;
import java.util.List;

public interface RoleDao {

    public RoleEntity findRoleByIdDao(Integer roleId) throws IOException;
    public List<RoleEntity> findRoleListDao() throws IOException;
    public void createRole(CreateRoleDto createRoleDto) throws IOException;
    public void editRole(EditRoleDto editRoleDto) throws IOException;

}
