package makeit.documents.comment.entity;

import lombok.Data;
import makeit.account.entity.Account;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jinhyung on 2015. 12. 7..
 */
@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue
    private Long srl;

    private String category;                // 학과게시판, 일반게시판 hackgua

    private Long docs;                      // 시리얼 {게시판번호}

    private String writerName;              // 작성자 표시이름

    @Lob
    private String content;                 // 댓글내용

    @Temporal(TemporalType.TIMESTAMP)
    private Date writeDate;                 // 작성일

    @OneToOne
    @JoinColumn(name = "writer")
    private Account account;                // 작성자

}
