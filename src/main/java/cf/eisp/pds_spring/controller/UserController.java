package cf.eisp.pds_spring.controller;

import cf.eisp.pds_spring.config.auth.PrincipalDetails;
import cf.eisp.pds_spring.model.Role;
import cf.eisp.pds_spring.model.User;
import cf.eisp.pds_spring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/join")
    public Integer join(@RequestBody User user) {
        User findUsername = userRepository.findByUsername(user.getUsername());
        if(findUsername != null) {
            return 0;
        }
        user.setUserRole(Role.USER);
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        System.out.println(user);
        return userRepository.save(user);
    }

    @GetMapping("/user")
    public void user(Authentication authentication) {
        String username = getUser(authentication);
        System.out.println(username);
    }

    //유저네임 리턴해주는 함수
    public static String getUser(Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        return principalDetails.getUsername();
    }
}
