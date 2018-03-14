package spring.webapp.database.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.webapp.database.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByEmail (String email);
}
