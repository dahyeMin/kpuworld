package makeit.noti;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jinhyung on 2015. 12. 11..
 */
@Data
@Entity
public class Noti {

    @Id
    @GeneratedValue
    private Long srl;

    private Long num;

    private String title;

    private String writer;

    @Temporal(TemporalType.DATE)
    private Date date;

    private int views;
}
