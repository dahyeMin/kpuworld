package makeit.documents.comment.service;

import lombok.extern.slf4j.Slf4j;
import makeit.account.entity.Account;
import makeit.account.entity.AccountRepository;
import makeit.documents.comment.entity.Comment;
import makeit.documents.comment.entity.CommentDto;
import makeit.documents.comment.entity.CommentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by jinhyung on 2015. 12. 11..
 */
@Service
@Transactional
@Slf4j
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;

    public Comment saveComment(Comment comment, String uuid) {

        comment.setWriteDate(new Date());

        comment = commentRepo.save(comment);

        Account account = accountRepository.findOneByUuid(uuid);

        comment.setAccount(account);

        return comment;
    }

    public Page findAll(String category, Long docs, Pageable pageable) {

        log.info("cage = {}, docs = {}", category, docs);

        Page page = commentRepo.findAllByCategoryAndDocs(category, docs, pageable);

        return page;
    }

    public Comment saveComment(CommentDto.Create create) {

        Comment comment = modelMapper.map(create, Comment.class);
        comment.setWriteDate(new Date());

        Account account = accountRepository.findOneByUuid(create.getUuid());

        comment = commentRepo.save(comment);

        comment.setAccount(account);

        return comment;
    }
}
