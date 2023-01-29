package JWT.jwt.dto.roleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoleResponseDto extends RoleDto{
    @NotNull(message = "User List Is Null")
    private List<String> userNameListDto;
}
