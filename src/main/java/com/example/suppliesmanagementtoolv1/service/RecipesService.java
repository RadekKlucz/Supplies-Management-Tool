package com.example.suppliesmanagementtoolv1.service;

import com.example.suppliesmanagementtoolv1.model.Recipes;
import com.example.suppliesmanagementtoolv1.repository.RecipesRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipesService {

    private final RecipesRepository recipesRepository;
//    private static final int PAGE_SIZE = 5;

    public RecipesService(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }
    public List<Recipes> getAllRecipes(int page, int sizeNumber) {
        return recipesRepository.findAllRecipes(PageRequest.of(page, sizeNumber));
    }

    public Recipes getSingleRecipe(long id) {
        return recipesRepository.findById(id).orElseThrow();
    }


}
