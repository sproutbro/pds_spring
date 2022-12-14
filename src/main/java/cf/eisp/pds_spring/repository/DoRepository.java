package cf.eisp.pds_spring.repository;

import cf.eisp.pds_spring.model.PlanDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoRepository {
    Integer save(PlanDo planDo);

    List<PlanDo> findAll();
}
