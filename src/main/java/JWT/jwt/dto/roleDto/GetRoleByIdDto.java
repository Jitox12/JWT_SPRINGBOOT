package JWT.jwt.dto.roleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class GetRoleByIdDto extends RoleDto{

    @NotNull(message = "RoleId Is Null")
    private Integer roleIdDto;
}
