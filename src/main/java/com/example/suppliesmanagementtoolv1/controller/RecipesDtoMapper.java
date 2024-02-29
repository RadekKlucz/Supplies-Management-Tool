package com.example.suppliesmanagementtoolv1.controller;

import com.example.suppliesmanagementtoolv1.dto.RecipeDto;
import com.example.suppliesmanagementtoolv1.dto.RecipesDto;
import com.example.suppliesmanagementtoolv1.model.Recipes;

import java.util.List;
import java.util.stream.Collectors;

public class RecipesDtoMapper {

    private RecipesDtoMapper() {}

    public static List<RecipesDto> mapToDtos(List<Recipes> recipes) {
        return recipes.stream()
                    .map(recipe -> mapToRecipleDto(recipe))
                    .collect(Collectors.toList());
        }

    private static RecipesDto mapToRecipleDto(Recipes recipe) {
            return RecipesDto.builder()
                    .id(recipe.getId())
                    .name(recipe.getName())
                    .description(recipe.getDescription())
                    .build();
    }
}
