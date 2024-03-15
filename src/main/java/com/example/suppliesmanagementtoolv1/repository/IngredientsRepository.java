package com.example.suppliesmanagementtoolv1.repository;

import com.example.suppliesmanagementtoolv1.model.Ingredients;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {

    @Query("SELECT ingredients FROM Ingredients AS ingredients")
    List<Ingredients> findAllIngredients(Pageable page);

    List<Ingredients> findAllByNameIn(Set<Ingredients> ingredientsList);

//    List<Ingredients> findAllByNameIsIn(List<Ingredients> ingredientsList);

//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Ingredients WHRE id IN(:ids)")
//    void deleteByIdIn(List<Integer> ids);
}