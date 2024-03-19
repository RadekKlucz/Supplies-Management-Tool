CREATE TABLE Supplies(
     Id BIGINT AUTO_INCREMENT PRIMARY KEY,
     Name VARCHAR(100) NOT NULL,
     Quantity INT NULL,
     Updated TIMESTAMP
);

CREATE TABLE Recipes(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(400) NOT NULL,
    Description VARCHAR(2000) NULL
);

CREATE TABLE Ingredients(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     Recipe_Id BIGINT NULL,
    Name VARCHAR(400) NOT NULL
--     Quantity INT NOT NULL
);

CREATE TABLE Recipes_Ingredients(
    Recipe_Id BIGINT NOT NULL,
    Ingredient_Id BIGINT NOT NULL
);

ALTER TABLE Recipes_Ingredients ADD CONSTRAINT RecipesIngredients_Id_1 FOREIGN KEY (Recipe_Id) REFERENCES Recipes(Id);
ALTER TABLE Recipes_Ingredients ADD CONSTRAINT RecipesIngredients_Id_2 FOREIGN KEY (Ingredient_Id) REFERENCES Ingredients(Id);


-- ALTER TABLE Ingredients ADD CONSTRAINT Ingredients_Recipe_Id FOREIGN KEY (Recipe_Id) REFERENCES Recipes(Id);