package cf.eisp.pds_spring.controller;

import cf.eisp.pds_spring.model.PlanDo;
import cf.eisp.pds_spring.repository.DoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DoController {

    private final DoRepository doRepository;
    @GetMapping("/do")
    public List<PlanDo> doCtl() {
        return doRepository.findAll();
    }
}
