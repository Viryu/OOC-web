package spring.webapp.database.repository;

import org.springframework.data.repository.CrudRepository;
import spring.webapp.database.entity.UserBalance;

public interface UserBalanceRepository extends CrudRepository<UserBalance,Long> {
    UserBalance findUserBalanceByUserid(Integer userid);
}
