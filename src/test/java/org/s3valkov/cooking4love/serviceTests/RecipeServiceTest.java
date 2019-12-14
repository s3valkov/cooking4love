package org.s3valkov.cooking4love.serviceTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.s3valkov.cooking4love.domain.entities.Level;
import org.s3valkov.cooking4love.domain.entities.Recipe;
import org.s3valkov.cooking4love.domain.models.service.RecipeServiceModel;
import org.s3valkov.cooking4love.repository.RecipeRepository;
import org.s3valkov.cooking4love.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RecipeServiceTest {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RecipeService service;

    @Test(expected = IllegalArgumentException.class)
    public void create_should_throw_exception() {
        Mockito.verify(service.createRecipe(null));
    }
}
