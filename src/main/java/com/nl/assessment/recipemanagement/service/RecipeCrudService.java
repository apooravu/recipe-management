package com.nl.assessment.recipemanagement.service;

import com.nl.assessment.recipemanagement.request.RecipeRequest;
import com.nl.assessment.recipemanagement.entity.IngredientEntity;
import com.nl.assessment.recipemanagement.entity.RecipeEntity;
import com.nl.assessment.recipemanagement.repository.IngredientRepository;
import com.nl.assessment.recipemanagement.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeCrudService {

    @Resource
    private RecipeRepository recipeRepository;

    @Resource
    private IngredientRepository ingredientRepository;

    public List<RecipeEntity> getRecipes() {
        return recipeRepository.findAll();
    }

    public List<IngredientEntity> getIngredients(RecipeEntity recipeEntity) {
        return ingredientRepository.findByRecipeEntity(recipeEntity);
    }

    public void deleteRecipe(RecipeRequest recipeRequest) {
        Optional<RecipeEntity> recipeEntity = recipeRepository.findByName(recipeRequest.getName());
        recipeEntity.ifPresent(recipeEntity1 -> recipeRepository.delete(recipeEntity1));
    }

    @Transactional
    public void saveRecipe(RecipeRequest recipeRequest) {
        RecipeEntity recipeEntity = recipeRepository.findByName(recipeRequest.getName()).isPresent() ? recipeRepository.findByName(recipeRequest.getName()).get() : new RecipeEntity(recipeRequest);
        recipeRepository.save(recipeEntity);
        recipeRequest.getIngredients().forEach(ingredient ->
                ingredientRepository.save(new IngredientEntity(ingredient, recipeEntity))
        );

    }
}
