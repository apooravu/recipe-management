package com.nl.assessment.recipemanagement.resource;

import com.nl.assessment.recipemanagement.request.RecipeRequest;
import com.nl.assessment.recipemanagement.controller.RecipeController;
import com.nl.assessment.recipemanagement.model.Recipe;
import com.nl.assessment.recipemanagement.validator.RecipeRequestValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class RecipeResource {

    @Resource
    RecipeController recipeController;

    @Resource
    private RecipeRequestValidator recipeRequestValidator;

    @GetMapping(value = "/recipe")
    public List<Recipe> getRecipeList(){
        return recipeController.getList();
    }

    @PutMapping(value = "/recipe")
    public void createRecipe(@RequestBody RecipeRequest recipeRequest){
        recipeRequestValidator.isValid(recipeRequest);
        recipeController.createRecipe(recipeRequest);
    }

    @DeleteMapping (value = "/recipe")
    public void deleteRecipe(@RequestBody RecipeRequest recipeRequest){
        recipeController.deleteRecipe(recipeRequest);
    }
}
