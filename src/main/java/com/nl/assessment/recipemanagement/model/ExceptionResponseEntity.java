package com.nl.assessment.recipemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class ExceptionResponseEntity {

    private int statusCode;
    private Date timestamp;
    private String message;

}
