package cf.eisp.pds_spring.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PlanDo {
    private Integer planId;
    private String planTitle;
    private String planMemo;
    private Timestamp planRegDate;
    private Timestamp planEndDate;
    private String username;
    private String planCategory;
    private String planPassword;
    private String planPrivate;
    private String doId;
    private Timestamp doDate;
    private String doState;

}
