package cf.eisp.pds_spring.controller;

import cf.eisp.pds_spring.model.Role;
import cf.eisp.pds_spring.model.User;
import cf.eisp.pds_spring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
}
