package JWT.jwt.controllers;

import JWT.jwt.dto.roleDto.RoleDto;
import JWT.jwt.dto.roleDto.RoleRequestDto;
import JWT.jwt.dto.roleDto.RoleResponseDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import JWT.jwt.repositories.RoleRepository;
import JWT.jwt.services.roleServices.RoleService;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@Validated
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleRepository roleRepository, RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value="api/find-role/{roleId}")
    public RoleResponseDto findOneRole(@PathVariable(required = true) Integer roleId) throws IOException, HttpClientErrorException {
        RoleResponseDto role = null;
        try{
            role = roleService.findRoleByIdService(roleId);
        }catch (IOException e){
            throw new IOException(e);
        }
            return role;
    }

    @GetMapping(value="api/find-roles")
    public List<RoleDto> findRoleList(){
        List<RoleDto> role = roleService.findRoleListService();
        return role;
    }

    @PostMapping(value = "api/create-role")
    public void createRole(@Valid @RequestBody RoleRequestDto roleDto){
        try {
            roleService.createRoleService(roleDto);
        }catch (Error e){
            throw new RuntimeException();
        }
    }

    @Transactional
    @PutMapping(value = "api/edit-role/{roleId}")
    public void editRole(@RequestBody RoleRequestDto roleReq, @PathVariable Integer roleId){
        roleService.editRoleService(roleId, roleReq);
    }
}