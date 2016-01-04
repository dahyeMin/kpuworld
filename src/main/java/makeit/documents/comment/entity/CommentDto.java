package makeit.documents.comment.entity;

import lombok.Data;
import makeit.account.entity.AccountDto;

import java.util.Date;

/**
 * Created by jinhyung on 2015. 12. 11..
 */
public class CommentDto {

    @Data
    public static class Response {
        private Long srl;

        private String writerName;              // 작성자 표시이름

        private String content;                 // 댓글내용

        private Date writeDate;                 // 작성일

        private AccountDto.Screat account;
    }
    @Data
    public static class Create {

        private String category;                // 학과게시판, 일반게시판

        private Long docs;                      // 시리얼

        private String writerName;              // 작성자 표시이름

        private String content;                 // 댓글내용

        private String uuid;

    }
}
