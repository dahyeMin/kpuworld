package makeit.account.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by jinhyung on 2015. 12. 11..
 */
public class AccountDto {

    @Data
    public static class Screat {
        private Long srl;

        private String uuid;
    }
    @Data
    public static class Update {
        private String name;

        private String major;

        private Integer hackBun;

        private String uuid;

        private String email;

        private String sexual;
    }
    @Data
    public static class Create {

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
    }
    @Data
    public static class Response {
        private Long srl;

        private String name;

        private String major;

        private Integer hackBun;

        private String uuid;

        private String email;

        private String sexual;

        private String phone;

        private Date joinDate;

        private Date lastLoginDate;
    }
}
