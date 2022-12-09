package cf.eisp.pds_spring.controller;

import cf.eisp.pds_spring.model.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/login")
    public Integer login(@RequestBody Member member, HttpSession session) {
        session.setAttribute("userID", member.getEmail());
        Object userID = session.getAttribute("userID");
        System.out.println("userID = " + userID);
        return 1;
    }

    @PostMapping("/loginCheck")
    public String loginCheck(HttpSession session) {
        Object userID = session.getAttribute("userID");
        System.out.println("userID = " + userID);
        return null;
    }

}
