package JWT.jwt.dao.roleDao;

import JWT.jwt.dto.roleDto.RoleDto;
import JWT.jwt.dto.roleDto.RoleRequestDto;
import JWT.jwt.entities.RoleEntity;

import java.io.IOException;
import java.util.List;

public interface RoleDao {

    public RoleEntity findRoleByIdDao(Integer roleId) throws IOException;
    public List<RoleEntity> findRoleListDao() throws IOException;
    public void createRole(RoleRequestDto roleDto) throws IOException;
    public void editRole(RoleRequestDto roleDto) throws IOException;

}
