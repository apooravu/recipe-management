package com.nl.assessment.recipemanagement.validator;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RecipeRequestValidator {

    @Resource
    private Validator validator;

    public void isValid(Object field){

        Set<ConstraintViolation<Object>> violations = validator.validate(field);
        if(!violations.isEmpty()){
            String constraints = violations.stream()
                    .map(entry -> entry.getPropertyPath() + " -> " + entry.getMessage())
                    .collect(Collectors.joining(", "));

            log.error("constraint violation occured for class{}: Constraints: [{}]",
                    field.getClass().getSimpleName(),constraints);
            throw new ConstraintViolationException(violations);
        }
    }

}
