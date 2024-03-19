package com.example.suppliesmanagementtoolv1.controller;

import com.example.suppliesmanagementtoolv1.dto.RecipesDto;
import com.example.suppliesmanagementtoolv1.model.Ingredients;
import com.example.suppliesmanagementtoolv1.model.Recipes;
import com.example.suppliesmanagementtoolv1.service.RecipesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipesController {

    private final RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }
    @GetMapping(path = "/recipes")
    public List<RecipesDto> getRecipes(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        int pageNumber = page != null && page > 0 ? page : 0;
        int sizeNumber = size != null && size > 0 ? size : 20;
        return RecipesDtoMapper.mapToDtos(recipesService.getAllRecipes(pageNumber, sizeNumber));
    }

    @GetMapping(path = "/recipes/{id}")
    public Recipes getRecipe(@PathVariable long id) {
        return recipesService.getSingleRecipe(id);
    }

    @PostMapping(path = "/recipes")
    public Recipes postRecipe(@RequestBody Recipes recipe) {
        return recipesService.postNewRecipe(recipe);
    }

    @PutMapping(path = "/recipes")
    public Recipes putRecipe(@RequestBody Recipes recipe) {
        return recipesService.editRecipe(recipe);
    }

    @DeleteMapping(path = "/recipes/{id}")
    public ResponseEntity<String> removeRecipe(@PathVariable long id) {
        recipesService.deleteRecipe(id);
        return ResponseEntity.ok("Recipe with id: " + id + " has been deleted");
    }

}