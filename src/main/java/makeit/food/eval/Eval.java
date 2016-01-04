package makeit.food.eval;

import lombok.Data;
import makeit.account.entity.Account;

import javax.persistence.*;
import java.util.Date;

/**
 * 음식평가
 * Created by jinhyung on 2015. 12. 12..
 */
@Entity
@Data
public class Eval {
    @Id
    @GeneratedValue
    private Long srl;                   // 시퀀스
    private String position;            // 위치 (tip, 산융, E동)
    private String category;            // 분류 (U9, 한스델리)
    private String name;                // 이름 (제육덮밥)
    private String body;                // 내용
    private String photo;               // 사진
    private Integer score;              // 점수 100점만점
    @OneToOne
    @JoinColumn(name = "writer")
    private Account writer;             // 작성자
    @Temporal(TemporalType.TIMESTAMP)
    private Date writeDate;             // 작성일
}
