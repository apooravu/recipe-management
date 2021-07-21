package com.nl.assessment.recipemanagement.controller;

import com.nl.assessment.recipemanagement.entity.RecipeEntity;
import com.nl.assessment.recipemanagement.model.Ingredients;
import com.nl.assessment.recipemanagement.model.Recipe;
import com.nl.assessment.recipemanagement.request.RecipeRequest;
import com.nl.assessment.recipemanagement.service.RecipeCrudService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipeController {

    @Resource
    RecipeCrudService recipeCrudService;

    public void createRecipe(RecipeRequest recipeRequest) {
        recipeCrudService.saveRecipe(recipeRequest);
    }

    public List<Recipe> getList() {
        List<Recipe> recipeList = new ArrayList<>();

        List<RecipeEntity> recipeEntityList = recipeCrudService.getRecipes();

        recipeEntityList.forEach(recipeEntity -> {

            recipeCrudService.getIngredients(recipeEntity);
            recipeList.add(Recipe.builder()
                    .name(recipeEntity.getName())
                    .ingredients(getIngredientList(recipeEntity))
                    .instructions(recipeEntity.getInstructions())
                    .isVegetarian(recipeEntity.isVegetarian())
                    .createdDate(transformDate(recipeEntity.getCreatedatetime()))
                    .serves(recipeEntity.getServes())
                    .build());
        });
        return recipeList;
    }

    private String transformDate(LocalDateTime createdatetime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return createdatetime.format(formatter);
    }

    private List<Ingredients> getIngredientList(RecipeEntity recipeEntity) {

        List<Ingredients> ingredientsList = new ArrayList<>();
        recipeCrudService.getIngredients(recipeEntity)
                .forEach(ingredientEntity ->
                        ingredientsList.add(Ingredients.builder()
                                .quantity(ingredientEntity.getQuanity())
                                .name(ingredientEntity.getName())
                                .units(ingredientEntity.getUnit())
                                .build())
                );
        return ingredientsList;
    }

    public void deleteRecipe(RecipeRequest recipeRequest) {
        recipeCrudService.deleteRecipe(recipeRequest);
    }
}
