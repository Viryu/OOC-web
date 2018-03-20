package spring.webapp.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.webapp.database.entity.UserInfo;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
}
