package JWT.jwt.dto.roleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class RoleDto {

    @NotBlank
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)

    private String roleDto;
}
