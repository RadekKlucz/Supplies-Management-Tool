package com.example.suppliesmanagementtoolv1.controller;

import com.example.suppliesmanagementtoolv1.dto.RecipesDto;
import com.example.suppliesmanagementtoolv1.model.Recipes;

import java.util.List;
import java.util.stream.Collectors;

public class RecipesDtoMapper {

    private RecipesDtoMapper() {}

    public static List<RecipesDto> mapToDtos(List<Recipes> recipes) {
        return recipes.stream()
                    .map(RecipesDtoMapper::mapToRecipeDto)
                    .collect(Collectors.toList());
        }

    private static RecipesDto mapToRecipeDto(Recipes recipe) {
            return RecipesDto.builder()
                    .id(recipe.getId())
                    .name(recipe.getName())
                    .description(recipe.getDescription())
                    .build();
    }
}
