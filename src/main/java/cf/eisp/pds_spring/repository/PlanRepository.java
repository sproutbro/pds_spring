package cf.eisp.pds_spring.repository;

import cf.eisp.pds_spring.model.Plan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanRepository {
    Integer save(Plan plan);

    List<Plan> findAll();

    Integer delete(Integer planId);

    List<Plan> findByUsername(String username);

    Plan findByPlanId(Integer planId);
}
