package org.s3valkov.cooking4love.web.controllers;

import org.modelmapper.ModelMapper;
import org.s3valkov.cooking4love.domain.models.binding.CategoryCreateBindingModel;
import org.s3valkov.cooking4love.domain.models.service.CategoryServiceModel;
import org.s3valkov.cooking4love.domain.models.view.CategoryViewModel;
import org.s3valkov.cooking4love.service.CategoryService;
import org.s3valkov.cooking4love.service.UserService;
import org.s3valkov.cooking4love.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController extends BaseController {
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final UserService userService;

    @Autowired
    public CategoryController(ModelMapper modelMapper, CategoryService categoryService, UserService userService) {
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PageTitle("Create Category")
    public ModelAndView create(Principal principal, ModelAndView modelAndView){
        modelAndView
                .addObject("model", this.modelMapper
                        .map(this.userService.findUserByUserName(principal.getName()), CategoryViewModel.class));
        return super.view("category/create-category");
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView addCategoryConfirm(@ModelAttribute CategoryCreateBindingModel model){
        CategoryServiceModel categoryServiceModel = this.modelMapper.map(model, CategoryServiceModel.class);
        this.categoryService.createCategory(categoryServiceModel);

        return super.redirect("/home");
    }

    @GetMapping("/all")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("All Categories")
    public ModelAndView all(ModelAndView modelAndView){
        List<CategoryServiceModel> categories = this.categoryService.findAllCategories();

        modelAndView.addObject("categories",categories);

        return super.view("category/all-categories",modelAndView);
    }
}
