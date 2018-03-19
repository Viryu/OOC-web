package spring.webapp.database.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.webapp.database.Entity.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByEmail (String email);
    User findOneByPassword (String password);
    List<User> findAll();
}
