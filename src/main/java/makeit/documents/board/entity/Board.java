package makeit.documents.board.entity;

import lombok.Getter;
import lombok.Setter;
import makeit.account.entity.Account;
import makeit.documents.DocCategory;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jinhyung on 2015. 12. 7..
 */
@Entity
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue
    private Long boardSrl;

    private DocCategory category;

    @OneToOne
    @JoinColumn(name = "writer_srl")
    private Account boardWriter;

    private String boardWriterName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Lob
    private String boardContent;

    private String password;

    private Long boardView;

    private String boardTitle;

}
