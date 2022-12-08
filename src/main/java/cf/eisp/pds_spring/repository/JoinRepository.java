package cf.eisp.pds_spring.repository;

import cf.eisp.pds_spring.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinRepository {

    Integer save(Member member);
}
