package kr.co.khBootAdmin.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserRoleVO {
    private Long id;
    private String name;
    private String email;
    private Boolean active;
    private Timestamp createdAt;
    private Long roleNo;
}
