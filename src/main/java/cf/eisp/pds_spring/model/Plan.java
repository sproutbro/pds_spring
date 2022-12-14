package cf.eisp.pds_spring.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Plan {
    private Integer planId;
    private String planTitle;
    private String planMemo;
    private Timestamp planEndDate;
    private Timestamp planRegDate;
    private String planPrivate;
    private String username;
    private String planPassword;
    private String planCategory;

    //나중에 빼든하자
    private Integer replyCount;
}
