package cf.eisp.pds_spring.controller;

import cf.eisp.pds_spring.config.auth.PrincipalDetails;
import cf.eisp.pds_spring.model.Plan;
import cf.eisp.pds_spring.model.PlanDo;
import cf.eisp.pds_spring.model.User;
import cf.eisp.pds_spring.repository.DoRepository;
import cf.eisp.pds_spring.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class PlanController {

    PlanRepository planRepository;
    DoRepository doRepository;
    @PostMapping("/plan")
    public Integer plan(@RequestBody Plan plan, Authentication authentication) {

        if(plan.getPlanEndDate() == null){
            Calendar instance = Calendar.getInstance();
            instance.add(Calendar.DATE, 1);
            Date date = new Date(instance.getTimeInMillis());
            Timestamp timestamp = new Timestamp(date.getTime());
            plan.setPlanEndDate(timestamp);
        }

        if (authentication != null) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            String username = principalDetails.getUsername();
            plan.setUsername(username);
        }

        return planRepository.save(plan);
    }

    @DeleteMapping("/delete")
    public Integer delete(@RequestBody Plan plan) {
        Integer planId = plan.getPlanId();
        return planRepository.delete(planId);
    }

    @PostMapping("/update")
    public Integer update(@RequestBody PlanDo planDo) {
        return doRepository.save(planDo);
    }


    @GetMapping("/plan")
    public List<Plan> findAllPlan() {
        return planRepository.findAll();
    }

    @GetMapping("/plan/{id}")
    public Plan findByPlanId(@PathVariable String id) {
        Integer planId = Integer.valueOf(id);
        return planRepository.findByPlanId(planId);
    }

    @GetMapping("/test")
    public String fjdio() {
        return "fdjiosdjiof";
    }
}
