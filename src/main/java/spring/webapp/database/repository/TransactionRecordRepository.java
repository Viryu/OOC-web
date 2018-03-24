package spring.webapp.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.webapp.database.entity.TransactionRecord;

@Repository
public interface TransactionRecordRepository extends CrudRepository<TransactionRecord, Long> {
}
