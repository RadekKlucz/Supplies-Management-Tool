package com.example.suppliesmanagementtoolv1.service;

import com.example.suppliesmanagementtoolv1.config.ResourceNotFoundException;
import com.example.suppliesmanagementtoolv1.model.Ingredients;
import com.example.suppliesmanagementtoolv1.model.Recipes;
import com.example.suppliesmanagementtoolv1.repository.IngredientsRepository;
import com.example.suppliesmanagementtoolv1.repository.RecipesRepository;
import org.hibernate.PersistentObjectException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipesService {

    private final RecipesRepository recipesRepository;
    private final IngredientsRepository ingredientsRepository;



    @Cacheable(cacheNames = "AllRecipes")
    public List<Recipes> getAllRecipes(int page, int sizeNumber) {
        return recipesRepository.findAllRecipes(PageRequest.of(page, sizeNumber));
    }

    @Cacheable(cacheNames = "SingleRecipe", key = "#id")
    public Recipes getSingleRecipe(long id) {
//        return recipesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supply not found with id: " + id));
        return recipesRepository.findRecipeById(id);
    }

//    @Transactional(rollbackFor = PersistentObjectException.class) // to check how transaction works
    @CacheEvict(cacheNames = "AllRecipes", allEntries = true)
    public Recipes postNewRecipe(Recipes recipe) {
        return recipesRepository.save(recipe);
    }


    @Transactional
    @CachePut(cacheNames = "SingleRecipe", key = "#result.id")
    @CacheEvict(cacheNames = "AllRecipes", allEntries = true)
    public Recipes editRecipe(Recipes recipe) {
        Recipes editedRecipe = recipesRepository.findRecipeById(recipe.getId());
        if (recipe.getName() != null) {
            editedRecipe.setName(recipe.getName());
        }
        if (recipe.getDescription() != null) {
            editedRecipe.setDescription(recipe.getDescription());
        }
        if (recipe.getIngredientsList() != null) {
//            is it required validation for ingredient here?
//            List<Ingredients> ingredients = recipe.getIngredientsList();
//            ingredientsRepository.findAllByNameIn(ingredients);
            editedRecipe.setIngredientsList(recipe.getIngredientsList());
        }
        return recipesRepository.save(editedRecipe);
    }

    @CachePut(cacheNames = "SingleRecipe", key = "#id")
    @CacheEvict(cacheNames = "AllRecipes", allEntries = true)
    public void deleteRecipe(long id) {
        recipesRepository.deleteById(id);
    }
}