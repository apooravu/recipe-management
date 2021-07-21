package com.nl.assessment.recipemanagement.request;

import com.nl.assessment.recipemanagement.model.Ingredients;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeRequest {

    @NotNull
    @Pattern(message = "the received name is in invalid format."
            , regexp = "[A-Za-z]{4,20}")
    private String name;
    @NotNull
    @Valid
    private List<Ingredients> ingredients;
    @NotNull
    private Integer serves;
    @NotNull
    @Pattern(message = "the received instructions is in invalid format."
            , regexp = "[A-Za-z]{4,300}")
    private String instructions;
    @NotNull
    private boolean vegetarian;


}
