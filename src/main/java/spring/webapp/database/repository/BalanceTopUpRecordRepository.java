package spring.webapp.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.webapp.database.entity.BalanceTopUpRecord;

@Repository
public interface BalanceTopUpRecordRepository extends CrudRepository<BalanceTopUpRecord,Long> {
}
