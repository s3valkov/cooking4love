package org.s3valkov.cooking4love.repository;

import org.s3valkov.cooking4love.domain.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {

    @Query("SELECT c FROM Comment  AS c  order by c.restaurant")
    List<Comment> findAllAndOrderByRestaurant();

    @Query("SELECT c FROM Comment  AS c  WHERE c.restaurant = ?1")
    List<Comment> findAllCommentsByRestaurant( String name);


}
