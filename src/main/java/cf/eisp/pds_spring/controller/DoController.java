package cf.eisp.pds_spring.controller;

import cf.eisp.pds_spring.model.PlanDo;
import cf.eisp.pds_spring.repository.DoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/do")
public class DoController {

    private final DoRepository doRepository;
    @RequestMapping("/save")
    public void doSave(PlanDo planDo) {
        doRepository.save(planDo);
    }
    @RequestMapping("/findAll")
    public List<PlanDo> doFindAll(){
        return doRepository.findAll();
    }
    @RequestMapping("/findById")
    public void doFindById(Integer planId) {
        doRepository.findById(planId);
    }
    @RequestMapping("/update")
    public void doUpdate(PlanDo planDo){
        doRepository.update(planDo);
    }

    @RequestMapping("/delete")
    public void doDelete(Integer planId) {
        doRepository.delete(planId);
    }
}
