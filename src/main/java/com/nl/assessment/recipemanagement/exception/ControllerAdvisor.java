package com.nl.assessment.recipemanagement.exception;

import com.nl.assessment.recipemanagement.model.ExceptionResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.Date;

@ControllerAdvice
@ResponseBody
public class ControllerAdvisor{

    @ExceptionHandler(ConstraintViolationException.class)
    public ExceptionResponseEntity handleProcessException(ConstraintViolationException e) {
        return new ExceptionResponseEntity(HttpStatus.BAD_REQUEST.value(),
                new Date(),
                e.getMessage());
    }
}
