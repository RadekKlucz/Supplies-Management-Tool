package com.example.suppliesmanagementtoolv1.service;

import com.example.suppliesmanagementtoolv1.config.ResourceNotFoundException;
import com.example.suppliesmanagementtoolv1.model.Ingredients;
import com.example.suppliesmanagementtoolv1.model.Recipes;
import com.example.suppliesmanagementtoolv1.repository.IngredientsRepository;
import com.example.suppliesmanagementtoolv1.repository.RecipesRepository;
import lombok.RequiredArgsConstructor;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientsService {

    private final IngredientsRepository ingredientsRepository;
    private final RecipesRepository recipesRepository;

    @Cacheable(cacheNames = "AllIngredients")
    public List<Ingredients> getAllIngredients(int page, int size) {
        return ingredientsRepository.findAllIngredients(PageRequest.of(page, size));
    }

    @Cacheable(cacheNames = "SingleIngredient", key = "#id")
    public Ingredients getSingleIngredient(long id) {
        return ingredientsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ingredient has not been found"));
    }

    @CacheEvict(cacheNames = "AllIngredients", allEntries = true)
    public List<Ingredients> addIngredients(List<Ingredients> ingredientsList) {
        return ingredientsRepository.saveAll(ingredientsList);
//        Should be added a restriction where the existing ingredients will be not upload into the database?
    }

//    in the future it will be moved to recipes
    public ResponseEntity<List<Ingredients>> postIngredients(long id, List<Ingredients> ingredientsRequest) {
        List<Ingredients> addedIngredients = new ArrayList<>();

        recipesRepository.findById(id).ifPresentOrElse(recipes -> {
            for (Ingredients ingredientRequest : ingredientsRequest) {
                long ingredientId = ingredientRequest.getId();
                // Check if the ingredient already exists
                if (ingredientId != 0L) {
                    Ingredients existingIngredient = ingredientsRepository.findById(ingredientId)
                            .orElseThrow();
                    recipes.addIngredient(existingIngredient);
                    recipesRepository.save(recipes);
                    addedIngredients.add(existingIngredient);
                } else {
                    // Add and create a new ingredient
                    recipes.addIngredient(ingredientRequest);
                    Ingredients addedIngredient = ingredientsRepository.save(ingredientRequest);
                    addedIngredients.add(addedIngredient);
                }
            }
        }, () -> {
            throw new RuntimeException("Recipe not found with id: " + id);
        });

        return new ResponseEntity<>(addedIngredients, HttpStatus.CREATED);
    }

    @CachePut(cacheNames = "SingleIngredient", key = "#result.id")
    @CacheEvict(cacheNames = "AllIngredients", allEntries = true)
    public Ingredients putIngredient(Ingredients editedIngredient, Ingredients ingredient) {
        editedIngredient.setName(ingredient.getName());
        return ingredientsRepository.save(editedIngredient);
    }

    @CacheEvict(cacheNames = {"AllIngredients", "SingleIngredient"}, allEntries = true)
    public void deleteIngredient(Long id) {
        ingredientsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ingredient has not been found"));
        ingredientsRepository.deleteById(id);
    }

    public List<Ingredients> getIngredientsByIds(List<Ingredients> ingredientsList) {
        List<Long> idsOfIngredients = ingredientsList.stream()
                .map(Ingredients::getId)
                .collect(Collectors.toList());
        return ingredientsRepository.findAllById(idsOfIngredients);
    }
}