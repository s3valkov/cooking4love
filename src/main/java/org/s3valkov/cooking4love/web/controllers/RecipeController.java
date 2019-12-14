package org.s3valkov.cooking4love.web.controllers;

import org.modelmapper.ModelMapper;
import org.s3valkov.cooking4love.domain.models.binding.RecipeCreateBindingModel;
import org.s3valkov.cooking4love.domain.models.service.RecipeServiceModel;
import org.s3valkov.cooking4love.domain.models.service.RestaurantServiceModel;
import org.s3valkov.cooking4love.service.RecipeService;
import org.s3valkov.cooking4love.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeController extends BaseController {
    private final ModelMapper modelMapper;
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(ModelMapper modelMapper, RecipeService recipeService) {
        this.modelMapper = modelMapper;
        this.recipeService = recipeService;
    }


    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Create Recipe")
    public ModelAndView create(Principal principal, ModelAndView modelAndView){
        modelAndView
                .addObject("model", this.modelMapper);
        return super.view("recipe/create-recipe");
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView addCategoryConfirm(@ModelAttribute RecipeCreateBindingModel model){
        RecipeServiceModel recipeServiceModel = this.modelMapper.map(model, RecipeServiceModel.class);
        this.recipeService.createRecipe(recipeServiceModel);

        return super.redirect("/home");
    }

    @GetMapping("/all")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("All Recipes")
    public ModelAndView all(ModelAndView modelAndView){
        List<RecipeServiceModel> recipes = this.recipeService.findAllRecipes();

        modelAndView.addObject("recipes",recipes);

        return super.view("recipe/all-recipes",modelAndView);
    }

    @GetMapping("/details/{id}")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Details Recipe")
    public ModelAndView detailsVideo(@PathVariable String id, ModelAndView modelAndView) {
        RecipeServiceModel recipe = this.recipeService.findRecipeById(id);
        modelAndView.addObject("recipe",recipe);

        return super.view("recipe/details-recipe", modelAndView);
    }

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
