package JWT.jwt.dto.roleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoleResponseDto extends RoleDto{
    private List<String> userNameListDto;
}
