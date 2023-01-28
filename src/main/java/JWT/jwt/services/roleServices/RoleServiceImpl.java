package JWT.jwt.services.roleServices;

import JWT.jwt.dao.roleDao.RoleDao;
import JWT.jwt.dto.roleDto.RoleDto;
import JWT.jwt.dto.roleDto.RoleRequestDto;
import JWT.jwt.dto.roleDto.RoleResponseDto;
import JWT.jwt.entities.RoleEntity;
import JWT.jwt.exceptionsConfig.exceptions.BadRequestException;
import JWT.jwt.exceptionsConfig.exceptions.NotFoundException;
import JWT.jwt.mappers.roleMappers.RoleNameResMapper;
import JWT.jwt.mappers.roleMappers.RoleReqMapper;
import JWT.jwt.mappers.roleMappers.RoleResMapper;
import JWT.jwt.utils.wordFormat.WordFormat;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    private final RoleReqMapper roleReqMapper;
    private final RoleResMapper roleResMapper;
    private final RoleNameResMapper roleNameResMapper;


    public RoleServiceImpl(RoleDao roleDao, RoleReqMapper roleReqMapper, RoleResMapper roleResMapper, RoleNameResMapper roleNameResMapper) {
        this.roleDao = roleDao;
        this.roleReqMapper = roleReqMapper;
        this.roleResMapper = roleResMapper;
        this.roleNameResMapper = roleNameResMapper;
    }

    @Override
    public RoleResponseDto findRoleByIdService(Integer roleId) throws IOException {
        RoleEntity role;
        try {
            role = roleDao.findRoleByIdDao(roleId);
        }catch (IOException e){
            throw new IOException(e.getMessage());
        }

            if(Objects.isNull(role)){
                throw new NotFoundException("Id: ".concat(String.valueOf(roleId)));
            }

            RoleResponseDto roleDto = roleResMapper.roleEntityToRoleResDto(role);
            return roleDto;
    }

    @Override
    public List<RoleDto> findRoleListService() {
        List<RoleDto> roleList = null;
        try {
            roleList = roleDao.findRoleListDao().stream().map(roleNameResMapper::roleEntityNameToRoleDto).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return roleList;
    }

    @Override
    public void createRoleService(RoleRequestDto roleReq) {



        String upperCaseRoleName = WordFormat.UpperCase(roleReq.getRoleDto());
        roleReq.setRoleDto(upperCaseRoleName);

        try {
            roleDao.createRole(roleReq);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editRoleService(Integer roleId, RoleRequestDto roleReq) {
        try {

            String upperCaseRoleName = WordFormat.UpperCase(roleReq.getRoleDto());
            roleReq.setRoleDto(upperCaseRoleName);
            roleReq.setRoleIdDto(roleId);

            roleDao.editRole(roleReq);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}