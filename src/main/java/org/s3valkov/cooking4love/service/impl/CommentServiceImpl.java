package org.s3valkov.cooking4love.service.impl;

import org.modelmapper.ModelMapper;
import org.s3valkov.cooking4love.domain.entities.Comment;
import org.s3valkov.cooking4love.domain.models.service.CommentServiceModel;
import org.s3valkov.cooking4love.error.Constants;
import org.s3valkov.cooking4love.error.exceptions.CommentNotFoundException;
import org.s3valkov.cooking4love.repository.CommentRepository;
import org.s3valkov.cooking4love.repository.RestaurantRepository;
import org.s3valkov.cooking4love.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final ModelMapper modelMapper;
    private final CommentRepository commentRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public CommentServiceImpl(ModelMapper modelMapper, CommentRepository commentRepository, RestaurantRepository restaurantRepository) {
        this.modelMapper = modelMapper;
        this.commentRepository = commentRepository;
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public CommentServiceModel createComment(CommentServiceModel commentServiceModel) {
        Comment comment = this.modelMapper.map(commentServiceModel, Comment.class);
        return this.modelMapper.map(this.commentRepository.saveAndFlush(comment), CommentServiceModel.class);
    }

    @Override
    public CommentServiceModel findCommentById(String id) {
        return this.commentRepository.findById(id)
                .map(c -> this.modelMapper.map(c, CommentServiceModel.class))
                .orElseThrow(() -> new CommentNotFoundException(Constants.COMMENT_NOT_FOUND));
    }

    @Override
    public void deleteComment(String id) {
        Comment comment = this.commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException(Constants.COMMENT_NOT_FOUND));

        this.commentRepository.delete(comment);
    }

    @Override
    public List<CommentServiceModel> findAllComments() {
        return this.commentRepository.findAllAndOrderByRestaurant()
                .stream()
                .map(c -> this.modelMapper.map(c, CommentServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentServiceModel> findAllByRestaurants(String name) {
        return this.commentRepository.findAllCommentsByRestaurant(name)
                .stream()
                .map(c -> this.modelMapper.map(c, CommentServiceModel.class))
                .collect(Collectors.toList());
    }

}
