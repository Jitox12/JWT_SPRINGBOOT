package JWT.jwt.dto.roleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class RoleDto {
    @NotNull(message = "Role Is Null")
    @NotEmpty(message = "Role Is Empty")
    @Size(min = 5, max = 25, message = "Min Size 5 & Max Size 15")
    private String roleDto;
}