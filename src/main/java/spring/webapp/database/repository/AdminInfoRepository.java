package spring.webapp.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.webapp.database.entity.AdminInfo;

@Repository
public interface AdminInfoRepository extends CrudRepository<AdminInfo,Long>{
    AdminInfo findAdminInfoByAdminID(Integer adminID);
}