package makeit.documents.comment.entity;

import makeit.documents.comment.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jinhyung on 2015. 12. 11..
 */
public interface CommentRepo extends JpaRepository<Comment, Long> {
    Page findAllByCategoryAndDocs(String category, Long docs, Pageable pageable);


}
