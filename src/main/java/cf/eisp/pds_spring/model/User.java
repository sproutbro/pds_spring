package cf.eisp.pds_spring.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private String username;
    private String password;
    private String userNickname;
    private Timestamp userRegDate;
    private Role userRole;
}
