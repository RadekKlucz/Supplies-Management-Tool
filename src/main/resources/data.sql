INSERT INTO Recipes(Id, Name, Description) VALUES (1, 'Recipe of tomato soup', 'Add tomato, potato and boil them in the watter');
INSERT INTO Recipes(Id, Name, Description) VALUES (2,  'Recipe of Milk', 'Add milk');

-- INSERT INTO Supplies(Id, Recipe_Id, Name, Quantity, Updated) VALUES (1, 1, 'Tomato', 2, '2020-01-23T13:14:05.562673800');
-- INSERT INTO Supplies(Id, Recipe_Id, Name, Quantity, Updated) VALUES (2, 1,  'Carrot', 2, '2020-01-23T13:14:05.562673800');
-- INSERT INTO Supplies(Id, Recipe_Id, Name, Quantity, Updated) VALUES (3, 1, 'Potato', 5, '2020-01-23T13:14:05.562673800');
-- INSERT INTO Supplies(Id, Recipe_Id, Name, Quantity, Updated) VALUES (4, 2, 'Milk', 1, '2020-01-23T13:14:05.562673800');
INSERT INTO Supplies(Id, Name, Quantity, Updated) VALUES (1, 'Bread', 1, '2020-01-23T13:14:05.562673800');
INSERT INTO Supplies(Id, Name, Quantity, Updated) VALUES (2, 'Bread', 1, '2020-01-23T13:14:05.562673800');
INSERT INTO Supplies(Id, Name, Quantity, Updated) VALUES (3, 'Bread', 1, '2020-01-23T13:14:05.562673800');
INSERT INTO Supplies(Id, Name, Quantity, Updated) VALUES (4, 'Bread', 1, '2020-01-23T13:14:05.562673800');

INSERT INTO Ingredients(Id, Name) VALUES (1, 'Bread');
INSERT INTO Ingredients(Id, Name) VALUES (2, 'Carrot');
INSERT INTO Ingredients(Id, Name) VALUES (3, 'Tomato');
INSERT INTO Ingredients(Id, Name) VALUES (4, 'Milk');

INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredients_Id) VALUES ( 1, 1 );
INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredients_Id) VALUES ( 2, 2 );
INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredients_Id) VALUES ( 1, 3 );
INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredients_Id) VALUES ( 1, 4 );
INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredients_Id) VALUES ( 2, 1 );
INSERT INTO Recipes_Ingredients(Recipe_Id, Ingredients_Id) VALUES ( 2, 4 );