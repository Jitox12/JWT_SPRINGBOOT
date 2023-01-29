package JWT.jwt.dao.roleDao;

import JWT.jwt.dto.roleDto.CreateRoleDto;
import JWT.jwt.dto.roleDto.EditRoleDto;
import JWT.jwt.entities.RoleEntity;
import org.springframework.stereotype.Component;
import JWT.jwt.repositories.RoleRepository;

import java.io.IOException;
import java.util.List;

@Component
public class RoleDaoImpl implements RoleDao {

    private final RoleRepository roleRepository;

    public RoleDaoImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity findRoleByIdDao(Integer roleId) throws IOException {
        RoleEntity role = null;
        role = roleRepository.findByRoleId(roleId);
        return role;

    }

    @Override
    public List<RoleEntity> findRoleListDao() throws IOException {
        List<RoleEntity> roleList = null;
        roleList = roleRepository.findAll();
        return roleList;
    }

    @Override
    public void createRole(CreateRoleDto createRoleDto) throws IOException {
        RoleEntity role = null;

        role = RoleEntity.builder()
                .role(createRoleDto.getRoleDto())
                .build();
        roleRepository.save(role);

    }

    @Override
    public void editRole(EditRoleDto editRoleDto) throws IOException {
        RoleEntity role = null;

        role = new RoleEntity().builder()
                .roleId(editRoleDto.getRoleIdDto())
                .role(editRoleDto.getRoleDto()).build();
        roleRepository.save(role);
    }
}