package spring.webapp.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.webapp.database.entity.FlightDetail;

import java.util.List;

@Repository
public interface FlightDetailRepository extends CrudRepository<FlightDetail,Long>{
    List<FlightDetail> findAllByAirline(String airline);
}
