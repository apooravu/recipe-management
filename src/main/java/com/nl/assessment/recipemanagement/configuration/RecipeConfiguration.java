package com.nl.assessment.recipemanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration
public class RecipeConfiguration {

    @Bean
    public Validator validator(){
      ValidatorFactory factory =  Validation.buildDefaultValidatorFactory();
      return factory.getValidator();
    }
}
