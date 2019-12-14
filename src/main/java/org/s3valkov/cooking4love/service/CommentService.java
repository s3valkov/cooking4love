package org.s3valkov.cooking4love.service;

import org.s3valkov.cooking4love.domain.models.service.CommentServiceModel;

import java.util.List;

public interface CommentService {

    CommentServiceModel createComment(CommentServiceModel commentServiceModel);

    CommentServiceModel findCommentById(String id);

    void deleteComment(String id);

    List<CommentServiceModel> findAllComments();


    List<CommentServiceModel> findAllByRestaurants(String name);
}
