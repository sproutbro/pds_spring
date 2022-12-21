package cf.eisp.pds_spring.config;

import cf.eisp.pds_spring.model.PlanDo;
import cf.eisp.pds_spring.repository.DoRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class Scheduler {
    private final DoRepository doRepository;

    // 1분마다 doList 출력
    @Scheduled(cron = "0 * * * * *")
    public void updatePlanState() {
        List<PlanDo> list = doRepository.findAll();
        System.out.println(list);
    }
}
