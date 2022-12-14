package cf.eisp.pds_spring.repository;

import cf.eisp.pds_spring.model.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyRepository {

    Integer save(Reply reply);

    List<Reply> findByPlanId(Integer planId);
}
