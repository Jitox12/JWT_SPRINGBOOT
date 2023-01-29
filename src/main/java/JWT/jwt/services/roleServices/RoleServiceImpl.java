package JWT.jwt.services.roleServices;

import JWT.jwt.dao.roleDao.RoleDao;
import JWT.jwt.dto.roleDto.CreateRoleDto;
import JWT.jwt.dto.roleDto.EditRoleDto;
import JWT.jwt.dto.roleDto.GetRoleDto;
import JWT.jwt.dto.roleDto.GetRoleNameDto;
import JWT.jwt.entities.RoleEntity;
import JWT.jwt.mappers.roleMappers.GetRoleNameMapper;
import JWT.jwt.mappers.roleMappers.GetRoleUserMapper;
import JWT.jwt.utils.wordFormat.WordFormat;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    private final GetRoleUserMapper getRoleMapper;
    private final GetRoleNameMapper getRoleNameMapper;

    public RoleServiceImpl(RoleDao roleDao, GetRoleUserMapper getRoleMapper, GetRoleNameMapper getRoleNameMapper) {
        this.roleDao = roleDao;
        this.getRoleMapper = getRoleMapper;
        this.getRoleNameMapper = getRoleNameMapper;
    }

    @Override
    public GetRoleDto findRoleByIdService(Integer roleId) {
        RoleEntity role;

        try {
            role = roleDao.findRoleByIdDao(roleId);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        GetRoleDto roleDto = getRoleMapper.roleEntityToGetRoleUserDto(role);
        return roleDto;
    }

    @Override
    public  List<GetRoleNameDto> findRoleListService() {
        List<GetRoleNameDto> roleList = null;
        try {
            roleList = roleDao.findRoleListDao().stream().map(getRoleNameMapper::roleEntityNameToGetRoleNameDto).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return roleList;
    }

    @Override
    public String createRoleService(CreateRoleDto createRoleReq) {
        String upperCaseRoleName = WordFormat.UpperCase(createRoleReq.getRoleDto());
        createRoleReq.setRoleDto(upperCaseRoleName);
        try {
            roleDao.createRole(createRoleReq);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return createRoleReq.getRoleDto();
    }

    @Override
    public String editRoleService(Integer roleId, EditRoleDto editRoleReq) {
        try {

            String upperCaseRoleName = WordFormat.UpperCase(editRoleReq.getRoleDto());
            editRoleReq.setRoleDto(upperCaseRoleName);
            editRoleReq.setRoleIdDto(roleId);

            roleDao.editRole(editRoleReq);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return editRoleReq.getRoleDto();
    }
}