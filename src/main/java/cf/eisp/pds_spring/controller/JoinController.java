package cf.eisp.pds_spring.controller;

import cf.eisp.pds_spring.model.Member;
import cf.eisp.pds_spring.model.Role;
import cf.eisp.pds_spring.repository.JoinRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class JoinController {

    private JoinRepository joinRepository;
    @PostMapping("/join")
    public Integer join(@RequestBody Member member) {
        member.setRole(Role.USER);
        return joinRepository.save(member);
    }
}
