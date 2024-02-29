package com.example.suppliesmanagementtoolv1.controller;

import com.example.suppliesmanagementtoolv1.dto.RecipesDto;
import com.example.suppliesmanagementtoolv1.model.Recipes;
import com.example.suppliesmanagementtoolv1.service.RecipesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipesController {

    private final RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }
    @GetMapping(path = "/recipes")
    public List<RecipesDto> getRecipes(@RequestParam(required = false) int page) {
        int pageNumber = page >= 0 ? page : 0;
        return RecipesDtoMapper.mapToDtos(recipesService.getAllRecipes(pageNumber));
    }

    @GetMapping(path = "/recipes/{id}")
    public Recipes getRecipe(@PathVariable long id) {
        return recipesService.getSingleRecipe(id);
    }
}