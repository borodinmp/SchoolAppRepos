package home.repos;

import home.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query(value = "SELECT * FROM usr u, user_role r WHERE u.id = r.user_id AND r.roles = 'USER'", nativeQuery = true)
    List<User> findByUserRole();
}
