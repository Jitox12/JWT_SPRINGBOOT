package JWT.jwt.repositories;

import JWT.jwt.entities.RoleEntity;
import JWT.jwt.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByEmail(String email);

}
