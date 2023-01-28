package JWT.jwt.dao.roleDao;

import JWT.jwt.dto.roleDto.RoleRequestDto;
import JWT.jwt.entities.RoleEntity;
import org.springframework.stereotype.Component;
import JWT.jwt.repositories.RoleRepository;

import javax.management.relation.Role;
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

        try {
            role = roleRepository.findByRoleId(roleId);

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return role;

    }

    @Override
    public List<RoleEntity> findRoleListDao() throws IOException {
        List<RoleEntity> roleList = null;
        try {
            roleList = roleRepository.findAll();

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return roleList;
    }

    @Override
    public void createRole(RoleRequestDto roleDto) throws IOException {
        RoleEntity role = null;
        try {
            role = RoleEntity.builder()
                    .role(roleDto.getRoleDto())
                    .build();
            roleRepository.save(role);

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void editRole(RoleRequestDto roleDto) throws IOException {
        RoleEntity role = null;
        try {
            role = new RoleEntity().builder()
                    .roleId(roleDto.getRoleIdDto())
                    .role(roleDto.getRoleDto()).build();
            roleRepository.save(role);

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}