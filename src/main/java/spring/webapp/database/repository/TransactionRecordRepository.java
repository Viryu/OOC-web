package spring.webapp.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.webapp.database.entity.FlightDetail;
import spring.webapp.database.entity.TransactionRecord;

@Repository
public interface TransactionRecordRepository extends JpaRepository<TransactionRecord, Long>, JpaSpecificationExecutor<TransactionRecord> {
    TransactionRecord findTransactionRecordByUserid(Integer userid);
    TransactionRecord findTransactionRecordByFlightno(String flightno);
    TransactionRecord findTransactionRecordByBookingcode(String bookingcode);
}
