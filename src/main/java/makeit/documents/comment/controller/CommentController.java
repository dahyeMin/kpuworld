package makeit.documents.comment.controller;

import makeit.documents.comment.service.CommentService;
import makeit.documents.comment.entity.Comment;
import makeit.documents.comment.entity.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jinhyung on 2015. 12. 11..
 */
@RestController
@RequestMapping("comment")
public class CommentController {


    @Autowired
    CommentService commentService;

    @Autowired
    ModelMapper modelMapper;


    @RequestMapping(method = RequestMethod.GET)
    public Page viewLIst(Pageable pageable, String category, Long docs) {

        Page<Comment> all = commentService.findAll(category, docs, pageable);
        List<CommentDto.Response> content = all.getContent().parallelStream()
                .map(comment -> modelMapper.map(comment, CommentDto.Response.class))
                .collect(Collectors.toList());

        return new PageImpl(content, pageable, all.getTotalElements());


    }
    @RequestMapping(method = RequestMethod.POST)
    public Comment putComment(@ModelAttribute CommentDto.Create create) {

        Comment returnComment = commentService.saveComment(create);

        return returnComment;


    }
}
