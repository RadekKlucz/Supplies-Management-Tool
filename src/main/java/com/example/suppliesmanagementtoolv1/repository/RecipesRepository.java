package com.example.suppliesmanagementtoolv1.repository;

import com.example.suppliesmanagementtoolv1.model.Ingredients;
import com.example.suppliesmanagementtoolv1.model.Recipes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Long> {

    @Query("SELECT recipes FROM Recipes AS recipes")
    List<Recipes> findAllRecipes(Pageable page);

//    @Query("SELECT recipes FROM Recipes AS recipes" + "LEFT JOIN FETCH ")
//    List<Ingredients> findAllByIngredientIdIn(List<Long> ids);

}