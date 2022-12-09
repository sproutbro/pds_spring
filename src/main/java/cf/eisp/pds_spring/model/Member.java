package cf.eisp.pds_spring.model;

import lombok.Data;

@Data
public class Member {
    private Integer id;
    private String username;
    private String password;
    private Enum Role;
}
