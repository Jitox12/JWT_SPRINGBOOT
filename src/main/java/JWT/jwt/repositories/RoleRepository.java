package JWT.jwt.repositories;

import JWT.jwt.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, String> {

    RoleEntity findByRoleId(Integer roleId);
    List<RoleEntity> findAll();
}
