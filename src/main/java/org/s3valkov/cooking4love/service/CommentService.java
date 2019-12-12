package org.s3valkov.cooking4love.service;

import org.s3valkov.cooking4love.domain.models.service.CommentServiceModel;

public interface CommentService {

    CommentServiceModel createComment(CommentServiceModel commentServiceModel);

    CommentServiceModel findCommentById(String id);

    void deleteComment(String id);

    CommentServiceModel editComment(String id, CommentServiceModel commentServiceModel);
}
