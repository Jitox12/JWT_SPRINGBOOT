package JWT.jwt.repositories;

import JWT.jwt.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUserId(Integer userId);
    List<UserEntity> findAll();

}
