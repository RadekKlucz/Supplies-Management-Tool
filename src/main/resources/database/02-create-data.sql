--liquibase formatted sql
--changeset rkluczewski:1
INSERT INTO Recipes( Name, Description) VALUES ( 'Recipe of tomato soup', 'Add tomato, potato and boil them in the watter');
INSERT INTO Recipes( Name, Description) VALUES (  'Recipe of Milk', 'Add milk');

-- INSERT INTO Supplies(Id, Recipe_Id, Name, Quantity, Updated) VALUES (1, 1, 'Tomato', 2, '2020-01-23T13:14:05.562673800');
-- INSERT INTO Supplies(Id, Recipe_Id, Name, Quantity, Updated) VALUES (2, 1,  'Carrot', 2, '2020-01-23T13:14:05.562673800');
-- INSERT INTO Supplies(Id, Recipe_Id, Name, Quantity, Updated) VALUES (3, 1, 'Potato', 5, '2020-01-23T13:14:05.562673800');
-- INSERT INTO Supplies(Id, Recipe_Id, Name, Quantity, Updated) VALUES (4, 2, 'Milk', 1, '2020-01-23T13:14:05.562673800');
INSERT INTO Supplies(Name, Quantity, Updated) VALUES ( 'Bread', 1, '2020-01-23T13:14:05.562673800');
INSERT INTO Supplies( Name, Quantity, Updated) VALUES ( 'Bread', 1, '2020-01-23T13:14:05.562673800');
INSERT INTO Supplies( Name, Quantity, Updated) VALUES ( 'Bread', 1, '2020-01-23T13:14:05.562673800');
INSERT INTO Supplies( Name, Quantity, Updated) VALUES ('Bread', 1, '2020-01-23T13:14:05.562673800');

INSERT INTO Ingredients( Name) VALUES ( 'Bread');
INSERT INTO Ingredients(Name) VALUES ('Carrot');
INSERT INTO Ingredients( Name) VALUES ( 'Tomato');
INSERT INTO Ingredients( Name) VALUES ( 'Milk');

INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredient_Id) VALUES ( 1, 1 );
INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredient_Id) VALUES ( 2, 2 );
INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredient_Id) VALUES ( 1, 3 );
INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredient_Id) VALUES ( 1, 4 );
INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredient_Id) VALUES ( 2, 1 );
INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredient_Id) VALUES ( 2, 4 );