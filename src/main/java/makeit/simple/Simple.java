package makeit.simple;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jinhyung on 2015. 12. 11..
 */
@Data
@Entity
public class Simple {

    @Id
    @GeneratedValue
    private Long srl;         // 시리얼

    private String content;         // 내용

    private String name;            // 표시될 이름

    @Temporal(TemporalType.TIMESTAMP)
    private Date writeDate;         // 쓴날짜

}
