package spring.webapp.database.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.webapp.database.Entity.TransactionRecord;

@Repository
public interface TransactionRecordRepository extends CrudRepository<TransactionRecord, Long> {
}
