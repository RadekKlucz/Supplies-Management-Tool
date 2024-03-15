package com.example.suppliesmanagementtoolv1.controller;

import com.example.suppliesmanagementtoolv1.config.ResourceNotFoundException;
import com.example.suppliesmanagementtoolv1.model.Ingredients;
import com.example.suppliesmanagementtoolv1.service.IngredientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    Should the method be added?
//    @PutMapping(path = "/ingredients")

//    @DeleteMapping(path = "/ingredients")
//    public void deleteIngredients(@RequestParam List<Long> ids) {
//        ingredientsService.deleteIngredientsByIds(ids);
//    }

    @PostMapping(path = "/recipes/{id}/ingredients")
    public ResponseEntity<List<Ingredients>> addIngredient(@PathVariable Long id, @RequestBody List<Ingredients> ingredientRequest) {
        return ingredientsService.postIngredients(id, ingredientRequest);
    }

    @PutMapping(path = "/ingredients")
    public List<Ingredients> editIngredients(@RequestBody List<Ingredients> ingredientsList) {
        return ingredientsService.putIngredients(ingredientsList);
    }

//    @DeleteMapping(path = "ingredients/{id}")
//    public ResponseEntity<Object> removeIngredient(@PathVariable Long id) {
//        try {
//            ingredientsService.deleteIngredient(id);
//            return new ResponseEntity<>("Ingredient with " + id + " has been deleted.", HttpStatus.OK);
//        } catch (ResourceNotFoundException e){
//            return new ResponseEntity<>("Ingredient with " + id + " has not been deleted.", HttpStatus.NOT_FOUND);
//        }
//    }
}