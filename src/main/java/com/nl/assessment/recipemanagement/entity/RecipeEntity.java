package com.nl.assessment.recipemanagement.entity;

import com.nl.assessment.recipemanagement.request.RecipeRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "RECIPE")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipesequencegenerator")
    @SequenceGenerator(name = "recipesequencegenerator", sequenceName = "RECIPESEQUENCE", allocationSize = 1)
    private long recipeId;

    @Column(unique=true)
    private String name ;

    private int serves;
    private boolean vegetarian;

    @CreationTimestamp
    private LocalDateTime createdatetime;
    private String instructions;


    public RecipeEntity(RecipeRequest recipeRequest) {
        name = recipeRequest.getName();
        serves = recipeRequest.getServes();
        instructions = recipeRequest.getInstructions();
        vegetarian = recipeRequest.isVegetarian();

    }
}
