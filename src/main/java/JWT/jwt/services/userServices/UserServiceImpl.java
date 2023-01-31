package JWT.jwt.services.userServices;

import JWT.jwt.dao.roleDao.RoleDao;
import JWT.jwt.dao.userDao.UserDao;
import JWT.jwt.dto.roleDto.GetRoleByIdDto;
import JWT.jwt.dto.userDto.CreateUserDto;
import JWT.jwt.dto.userDto.EditUserDto;
import JWT.jwt.dto.userDto.GetUserDto;
import JWT.jwt.entities.RoleEntity;
import JWT.jwt.entities.UserEntity;
import JWT.jwt.exceptionsConfig.exceptions.BadRequestException;
import JWT.jwt.mappers.roleMappers.GetRoleByIdMapper;
import JWT.jwt.mappers.userMappers.GetUserMapper;
import JWT.jwt.utils.wordFormat.PasswordEncodeUtils;
import JWT.jwt.utils.wordFormat.WordFormatUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;
    private final GetUserMapper getUserMapper;
    private final GetRoleByIdMapper getRoleNameMapper;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao, GetUserMapper getUserMapper, GetRoleByIdMapper getRoleNameMapper) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.getUserMapper = getUserMapper;
        this.getRoleNameMapper = getRoleNameMapper;
    }

    @Override
    public GetUserDto findUserByIdService(Integer userId) {
        try {
            UserEntity user = userDao.findUserByIdDao(userId);

            if(Objects.isNull(user)){
                throw new BadRequestException("User does not exist");
            }

            GetUserDto userDto = getUserMapper.userEntityToGetUserDto(user);
            return userDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GetUserDto> findUserListService() {
        try {
            List<UserEntity> user = userDao.findUserListDao();

            if(Objects.isNull(user)){
                throw new BadRequestException("User List does not exist");
            }

            List<GetUserDto> userRes = user.stream().map(getUserMapper::userEntityToGetUserDto).collect(Collectors.toList());
            return userRes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String createUserService(CreateUserDto createUserReq) {
        RoleEntity role = null;
        GetRoleByIdDto roleDto = null;

        //Mayus first Key
        String userNameUpperCase = WordFormatUtils.UpperCase(createUserReq.getUserNameDto());
        String userLastNameUpperCase = WordFormatUtils.UpperCase(createUserReq.getUserLastNameDto());

        //Encode Password
        String encodePassword = PasswordEncodeUtils.passwordEncoder().encode(createUserReq.getPasswordDto());

        //LowerCase Email
        String emailLowerCase = createUserReq.getEmailDto().toLowerCase();

        //Set new Values
        createUserReq.setUserNameDto(userNameUpperCase);
        createUserReq.setUserLastNameDto(userLastNameUpperCase);
        createUserReq.setPasswordDto(encodePassword);
        createUserReq.setEmailDto(emailLowerCase);

        try {
            role = roleDao.findRoleByIdDao(createUserReq.getRoleIdDto());
            if (Objects.isNull(role)) {
                throw new BadRequestException("Id ".concat(String.valueOf(createUserReq.getRoleIdDto())));
            }
            roleDto = getRoleNameMapper.roleEntityNameToGetRoleByIdDto(role);

            userDao.createUserDao(createUserReq, roleDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return createUserReq.getUserNameDto();
    }

    @Override
    public String editUserService(Integer userId, EditUserDto editUserReq) {
        RoleEntity role = null;
        GetRoleByIdDto roleDto = null;

        //Mayus first Key
        String userNameUpperCase = WordFormatUtils.UpperCase(editUserReq.getUserNameDto());
        String userLastNameUpperCase = WordFormatUtils.UpperCase(editUserReq.getUserLastNameDto());

        //Encode Password
        String encodePassword = PasswordEncodeUtils.passwordEncoder().encode(editUserReq.getPasswordDto());

        //LowerCase Email
        String emailLowerCase = editUserReq.getEmailDto().toLowerCase();

        //Set new Values
        editUserReq.setUserNameDto(userNameUpperCase);
        editUserReq.setUserLastNameDto(userLastNameUpperCase);
        editUserReq.setPasswordDto(encodePassword);

        try {
            role = roleDao.findRoleByIdDao(editUserReq.getRoleIdDto());
            if (Objects.isNull(role)) {
                throw new BadRequestException("Id ".concat(String.valueOf(editUserReq.getRoleIdDto())));
            }
            roleDto = getRoleNameMapper.roleEntityNameToGetRoleByIdDto(role);
            userDao.editUserDao(editUserReq, roleDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return editUserReq.getUserNameDto();
    }
}
