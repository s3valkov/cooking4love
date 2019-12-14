package org.s3valkov.cooking4love.web.controllers;

import org.modelmapper.ModelMapper;
import org.s3valkov.cooking4love.domain.models.binding.RestaurantCreateBindingModel;
import org.s3valkov.cooking4love.domain.models.service.CommentServiceModel;
import org.s3valkov.cooking4love.domain.models.service.RestaurantServiceModel;
import org.s3valkov.cooking4love.error.exceptions.RestaurantNotFoundException;
import org.s3valkov.cooking4love.service.CommentService;
import org.s3valkov.cooking4love.service.RestaurantService;
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
@RequestMapping("/restaurants")
public class RestaurantController extends BaseController {
    private final ModelMapper modelMapper;
    private final RestaurantService restaurantService;
    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public RestaurantController(ModelMapper modelMapper, RestaurantService restaurantService, CommentService commentService, UserService userService) {
        this.modelMapper = modelMapper;
        this.restaurantService = restaurantService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PageTitle("Create Restaurant")
    public ModelAndView create(Principal principal, ModelAndView modelAndView) {
        modelAndView
                .addObject("model", this.modelMapper);
        return super.view("restaurant/create-restaurant");
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView addCategoryConfirm(@ModelAttribute RestaurantCreateBindingModel model) {
        RestaurantServiceModel restaurantServiceModel = this.modelMapper.map(model, RestaurantServiceModel.class);
        this.restaurantService.createRestaurant(restaurantServiceModel);

        return super.redirect("/home");
    }

    @GetMapping("/all")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("All Restaurants")
    public ModelAndView all(ModelAndView modelAndView) {
        List<RestaurantServiceModel> restaurants = this.restaurantService.findAllRestaurants();
        modelAndView.addObject("restaurants", restaurants);
        return super.view("restaurant/all-restaurants",modelAndView);
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PageTitle("Edit Restaurant")
    public ModelAndView editRestaurant(@PathVariable String id, ModelAndView modelAndView){
        RestaurantServiceModel restaurantServiceModel = this.restaurantService.findRestaurantById(id);

        modelAndView.addObject("restaurant", restaurantServiceModel);
        modelAndView.addObject("restaurantId", id);


        return super.view("restaurant/edit-restaurant",modelAndView);

    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView editRestaurantConfirm(@PathVariable String id,@ModelAttribute RestaurantCreateBindingModel model){
        this.restaurantService.editRestaurant(id, this.modelMapper.map(model, RestaurantServiceModel.class));

        return super.redirect("/home");
    }

    @GetMapping("/details/{id}")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Details Restaurant")
    public ModelAndView detailsVideo(@PathVariable String id, ModelAndView modelAndView) {
        RestaurantServiceModel restaurant = this.restaurantService.findRestaurantById(id);
        modelAndView.addObject("restaurant",restaurant);
        return super.view("restaurant/details-restaurant", modelAndView);
    }


    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PageTitle("Delete Restaurant")
    public ModelAndView deleteRestaurant(@PathVariable String id, ModelAndView modelAndView) {
        RestaurantServiceModel restaurantServiceModel = this.restaurantService.findRestaurantById(id);

        modelAndView.addObject("restaurant", restaurantServiceModel);
        modelAndView.addObject("restaurantId", id);

        return super.view("restaurant/delete-restaurant", modelAndView);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView deleteRestaurantConfirm(@PathVariable String id) {
        this.restaurantService.deleteRestaurant(id);

        return super.redirect("/home");
    }



    @ExceptionHandler({RestaurantNotFoundException.class})
    public ModelAndView handleRestaurantNotFound(RestaurantNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", e.getMessage());
        modelAndView.addObject("statusCode", e.getStatus());

        return modelAndView;
    }


}
