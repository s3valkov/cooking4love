package org.s3valkov.cooking4love.web.controllers;

import org.modelmapper.ModelMapper;
import org.s3valkov.cooking4love.domain.models.binding.CategoryCreateBindingModel;
import org.s3valkov.cooking4love.domain.models.binding.CommentCreateBindingModel;
import org.s3valkov.cooking4love.domain.models.service.CommentServiceModel;
import org.s3valkov.cooking4love.domain.models.view.CommentViewModel;
import org.s3valkov.cooking4love.service.CommentService;
import org.s3valkov.cooking4love.service.UserService;
import org.s3valkov.cooking4love.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController extends BaseController {
    private final ModelMapper modelMapper;
    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public CommentController(ModelMapper modelMapper, CommentService commentService, UserService userService) {
        this.modelMapper = modelMapper;
        this.commentService = commentService;
        this.userService = userService;
    }


    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Add Comment")
    public ModelAndView create(Principal principal, ModelAndView modelAndView){
        modelAndView
                .addObject("model", this.modelMapper
                        .map(this.userService.findUserByUserName(principal.getName()), CommentViewModel.class));
        return super.view("comment/create-comment");
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView addCategoryConfirm(@ModelAttribute CommentCreateBindingModel model){
        CommentServiceModel commentServiceModel = this.modelMapper.map(model, CommentServiceModel.class);
        this.commentService.createComment(commentServiceModel);

        return super.redirect("/home");
    }

    @GetMapping("/all")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("All Comments")
    public ModelAndView all(ModelAndView modelAndView){
        List<CommentServiceModel> comments = this.commentService.findAllComments();

        modelAndView.addObject("comments",comments);

        return super.view("comment/all-comments",modelAndView);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PageTitle("Delete Comment")
    public ModelAndView deleteComment(@PathVariable String id, ModelAndView modelAndView) {
        CommentServiceModel commentServiceModel = this.commentService.findCommentById(id);

        modelAndView.addObject("comment", commentServiceModel);
        modelAndView.addObject("commentId", id);

        return super.view("comment/delete-comment", modelAndView);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView deleteCommentConfirm(@PathVariable String id) {
        this.commentService.deleteComment(id);

        return super.redirect("/home");
    }
}
