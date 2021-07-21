package com.nl.assessment.recipemanagement.entity;

import com.nl.assessment.recipemanagement.model.Ingredients;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "INGREDIENT")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredientsequencegenerator")
    @SequenceGenerator(name = "ingredientsequencegenerator", sequenceName = "INGREDIENT_SQ", allocationSize = 1)
    private long ingredientId;

    private String name;
    private int quanity;
    private String unit;

    @ManyToOne
    @JoinColumn(name = "recipeId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RecipeEntity recipeEntity;


    public IngredientEntity(Ingredients ingredients, RecipeEntity recipeEntity) {
        this.name = ingredients.getName();
        this.recipeEntity = recipeEntity;
        this.unit = ingredients.getUnits();
        this.quanity = ingredients.getQuantity();
    }
}
