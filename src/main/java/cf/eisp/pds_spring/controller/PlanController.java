package cf.eisp.pds_spring.controller;

import cf.eisp.pds_spring.model.Plan;
import cf.eisp.pds_spring.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class PlanController {

    PlanRepository planRepository;
    @PostMapping("/plan")
    public void plan(@RequestBody Plan plan) {


        if(plan.getEndDate() == null){
            Calendar instance = Calendar.getInstance();
            instance.add(Calendar.DATE, 1);
            Date date = new Date(instance.getTimeInMillis());
            Timestamp timestamp = new Timestamp(date.getTime());
            plan.setEndDate(timestamp);
        }
        Integer save = planRepository.save(plan);
        System.out.println("save = " + save);
    }

    @GetMapping("/plan")
    public List<Plan> findAllPlan() {
        return planRepository.findAll();
    }
}
