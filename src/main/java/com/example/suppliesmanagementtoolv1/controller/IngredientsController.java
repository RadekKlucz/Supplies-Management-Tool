package com.example.suppliesmanagementtoolv1.controller;

import com.example.suppliesmanagementtoolv1.config.ResourceNotFoundException;
import com.example.suppliesmanagementtoolv1.model.Ingredients;
import com.example.suppliesmanagementtoolv1.service.IngredientsService;
import lombok.RequiredArgsConstructor;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @GetMapping(path = "/ingredients")
    public List<Ingredients> getIngredients(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        int pageNumber = page !=null && page >= 0 ? page : 0;
        int sizeNumber = size != null && size > 0 ? size : 20;
        return ingredientsService.getAllIngredients(pageNumber, sizeNumber);
    }

    @GetMapping(path = "ingredients/{id}")
    public Ingredients getIngredient(@PathVariable long id) {
        return ingredientsService.getSingleIngredient(id);
    }

    @PostMapping(path = "/ingredients")
    public List<Ingredients> postIngredients(@RequestBody List<Ingredients> ingredientsList) {
        return ingredientsService.addIngredients(ingredientsList);
    }

    @PostMapping(path = "/recipes/{id}/ingredients") // will be moved to recipes
    public ResponseEntity<List<Ingredients>> addIngredient(@PathVariable Long id, @RequestBody List<Ingredients> ingredientRequest) {
        return ingredientsService.postIngredients(id, ingredientRequest);
    }

    @PutMapping(path = "/ingredients")
    public List<Ingredients> editIngredients(@RequestBody List<Ingredients> ingredientsList) {
        List<Ingredients> result = new ArrayList<>();
        List<Ingredients> existingIngredients = ingredientsService.getIngredientsByIds(ingredientsList);
        for (Ingredients ingredient: ingredientsList) {
            for (Ingredients existingIngredient: existingIngredients) {
                if (ingredient.getId() == existingIngredient.getId()) {
                    result.add(ingredientsService.putIngredient(existingIngredient, ingredient));
                }
            }
        }
        return result;
    }

    @DeleteMapping(path = "ingredients/{id}") // find accurate exception for catch
    public ResponseEntity<Object> removeIngredient(@PathVariable Long id) {
        try {
            ingredientsService.deleteIngredient(id);
            return new ResponseEntity<>("Ingredient with " + id + " has been deleted.", HttpStatus.OK);
        } catch (ResourceNotFoundException e){
            return new ResponseEntity<>("Ingredient with " + id + " has not been deleted because it does not exist.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Ingredient with " + id + " has assigned recipe. Cannot delete this ingredient",HttpStatus.NOT_ACCEPTABLE);
        }
    }
}