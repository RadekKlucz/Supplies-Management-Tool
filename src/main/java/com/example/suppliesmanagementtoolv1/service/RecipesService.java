package com.example.suppliesmanagementtoolv1.service;

import com.example.suppliesmanagementtoolv1.model.Ingredients;
import com.example.suppliesmanagementtoolv1.model.Recipes;
import com.example.suppliesmanagementtoolv1.repository.IngredientsRepository;
import com.example.suppliesmanagementtoolv1.repository.RecipesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RecipesService {

    private final RecipesRepository recipesRepository;
    private final IngredientsRepository ingredientsRepository;



    public List<Recipes> getAllRecipes(int page, int sizeNumber) {
        return recipesRepository.findAllRecipes(PageRequest.of(page, sizeNumber));
    }

    public Recipes getSingleRecipe(long id) {
        return recipesRepository.findById(id).orElseThrow();
    }

    public Recipes postNewRecipe(Recipes recipe) {
        return recipesRepository.save(recipe);
    }

    public List<Ingredients> postIngredientsForRecipe(int recipeId, List<Ingredients> ingredients) {
        return ingredients;
    }

    @Transactional
    public Recipes editRecipe(Recipes recipe) {
        Recipes editedRecipe = recipesRepository.findById(recipe.getId()).orElseThrow();
        List<Ingredients> ingredientsList = recipe.getIngredientsList();

        editedRecipe.setName(recipe.getName());
        editedRecipe.setDescription(recipe.getDescription());

        editedRecipe.setIngredientsList(recipe.getIngredientsList());
        return recipesRepository.save(editedRecipe);
    }
}