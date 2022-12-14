package cf.eisp.pds_spring.controller;

import cf.eisp.pds_spring.config.auth.PrincipalDetails;
import cf.eisp.pds_spring.model.Plan;
import cf.eisp.pds_spring.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/plan")
@AllArgsConstructor
public class UserPlanController {

    private final PlanRepository planRepository;

    @GetMapping({"","/"})
    public List<Plan> userPlan(Authentication authentication) {
        String username = getUser(authentication);
        return planRepository.findByUsername(username);
    }

    //유저네임 리턴해주는 함수
    public static String getUser(Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        return principalDetails.getUsername();
    }
}
