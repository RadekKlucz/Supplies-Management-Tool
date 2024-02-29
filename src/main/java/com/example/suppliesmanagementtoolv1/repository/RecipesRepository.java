package com.example.suppliesmanagementtoolv1.repository;

import com.example.suppliesmanagementtoolv1.model.Recipes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipesRepository extends JpaRepository<Recipes, Long> {

    @Query("SELECT recipes FROM Recipes AS recipes")
    List<Recipes> findAllRecipes(Pageable page);

}