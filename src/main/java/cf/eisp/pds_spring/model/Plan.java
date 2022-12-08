package cf.eisp.pds_spring.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Plan {
    private Integer id;
    private String title;
    private String memo;
    private Timestamp endDate;
    private Timestamp regDate;
    private Integer privateYN;
    private String email;
}
