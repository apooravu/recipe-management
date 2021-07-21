package com.nl.assessment.recipemanagement.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Recipe {
    String name;
    List<Ingredients> ingredients;
    int serves;
    String instructions;
    boolean isVegetarian;
    String createdDate;

}
