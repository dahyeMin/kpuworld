package makeit.account.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jinhyung on 2015. 12. 10..
 */
@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long srl;

    private String name;

    private String major;

    private Integer hackBun;

    private String uuid;

    private String email;

    private String sexual;

    private String password;

    private String phone;

    private String role;

    private String push;

    private String fbid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;

}
