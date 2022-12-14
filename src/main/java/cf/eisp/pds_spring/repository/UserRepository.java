package cf.eisp.pds_spring.repository;

import cf.eisp.pds_spring.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    Integer save(User user);

    User findByUsername(String username);
}
