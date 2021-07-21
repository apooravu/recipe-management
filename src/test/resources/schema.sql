CREATE TABLE RECIPE {
recipeId INTEGER NOT NULL,
name VARCHAR(20) UNIQUE NOT NUll,
serves INTEGER NOT NULL,
vegetarian SMALLINT NOT NULL,
createDateTime TIMESTAMP NOT NULL,
instructions VARCHAR NOT NULL,
CONSTRAINT RECIPE_PK PRIMARY KEY (recipeId)
};

CREATE SEQUENCE RECIPESEQUENCE START WITH 1;

CREATE TABLE INGREDIENT {
ingredientId INTEGER NOT NULL,
name VARCHAR(20) NOT NUll,
quantity INTEGER NOT NULL,
unit VARCHAR (5) NOT NUll,
recipeId INTEGER NOT NULL,
CONSTRAINT INGREDIENTID_PK PRIMARY KEY (ingredientId),
CONSTRAINT INGREDIENTID_PK FOREIGN KEY (recipeId) REFERENCES RECIPE(recipeId)
};

CREATE SEQUENCE INGREDIENT_SQ START WITH 1;