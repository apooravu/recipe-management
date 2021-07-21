package com.nl.assessment.recipemanagement.repository;

import com.nl.assessment.recipemanagement.entity.IngredientEntity;
import com.nl.assessment.recipemanagement.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

    List<IngredientEntity> findByRecipeEntity(RecipeEntity recipeEntity);
}
