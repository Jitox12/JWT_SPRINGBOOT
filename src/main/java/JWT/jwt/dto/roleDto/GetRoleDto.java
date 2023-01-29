package JWT.jwt.dto.roleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetRoleDto extends RoleDto {

    @NotNull(message = "User List Is Null")
    @NotEmpty(message = "User List is Empty")
    private List<String> userNameListDto;
}