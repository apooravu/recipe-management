package com.nl.assessment.recipemanagement.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class Ingredients {
    @NotNull
    @Pattern(message = "the received ingredient name is in invalid format."
            ,regexp = "[A-Za-z]{4,20}")
    private String name ;
    @NotNull
    private Integer quantity;
    @NotNull
    @Pattern(message = "the received unit is in invalid format."
            ,regexp = "[A-Za-z]{2,5}")
    private String units;

}
