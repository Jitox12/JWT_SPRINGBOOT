package JWT.jwt.controllers;

import JWT.jwt.dto.roleDto.CreateRoleDto;
import JWT.jwt.dto.roleDto.EditRoleDto;
import JWT.jwt.dto.roleDto.GetRoleDto;
import JWT.jwt.dto.roleDto.GetRoleNameDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import JWT.jwt.repositories.RoleRepository;
import JWT.jwt.services.roleServices.RoleService;

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

    @GetMapping(value = "api/find-role/{roleId}")
    public GetRoleDto findOneRole(@PathVariable(required = true) @Valid Integer roleId) throws IOException {
        GetRoleDto role = null;
        role = roleService.findRoleByIdService(roleId);
        return role;
    }

    @GetMapping(value = "api/find-roles")
    public List<GetRoleNameDto> findRoleList()  throws IOException{
        List<GetRoleNameDto> role = roleService.findRoleListService();
        return role;
    }
    @Transactional
    @PostMapping(value = "api/create-role")
    public String createRole(@RequestBody @Valid CreateRoleDto createRoleDto ) throws IOException{
        String role = roleService.createRoleService(createRoleDto);
        return "Se ha creado el rol ".concat(role);
    }

    @Transactional
    @PutMapping(value = "api/edit-role/{roleId}")
    public String editRole(@RequestBody @Valid EditRoleDto editRoleReq, @PathVariable(required = true) Integer roleId) throws IOException {
        String role = roleService.editRoleService(roleId, editRoleReq);

        return "Se ha editado el rol con Id ".concat(String.valueOf(roleId));
    }
}