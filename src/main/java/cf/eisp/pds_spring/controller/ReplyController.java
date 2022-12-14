package cf.eisp.pds_spring.controller;

import cf.eisp.pds_spring.config.auth.PrincipalDetails;
import cf.eisp.pds_spring.model.Reply;
import cf.eisp.pds_spring.repository.ReplyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReplyController {

    ReplyRepository replyRepository;
    @GetMapping("/reply/{planId}")
    public List<Reply> reply(@PathVariable Integer planId) {
        return replyRepository.findByPlanId(planId);
    }

    @PostMapping("/reply")
    public Integer saveReply(@RequestBody Reply reply, Authentication authentication) {
        String user = getUser(authentication);
        reply.setUsername(user);
        reply.setReplyPassword("1");
        return replyRepository.save(reply);
    }

    //유저네임 리턴해주는 함수
    //나중에 서비스로 빼자
    public static String getUser(Authentication authentication) {
        if(authentication != null) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            return principalDetails.getUsername();
        }
        return null;
    }
}
