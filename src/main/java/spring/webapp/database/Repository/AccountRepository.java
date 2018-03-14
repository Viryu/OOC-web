package spring.webapp.database.Repository;

import org.springframework.data.repository.CrudRepository;
import spring.webapp.database.Entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByEmail (String email);

}
