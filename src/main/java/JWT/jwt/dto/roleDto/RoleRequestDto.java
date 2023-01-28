package JWT.jwt.dto.roleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleRequestDto extends RoleDto{
    private Integer roleIdDto;
}
