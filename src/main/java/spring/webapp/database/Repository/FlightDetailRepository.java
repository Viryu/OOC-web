package spring.webapp.database.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.webapp.database.Entity.FlightDetail;

@Repository
public interface FlightDetailRepository extends CrudRepository<FlightDetail,Long>{
}
