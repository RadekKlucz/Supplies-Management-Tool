package com.example.suppliesmanagementtoolv1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Recipes_Ingredients", joinColumns = @JoinColumn(name = "Recipe_Id",
    referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "Ingredient_Id",
    referencedColumnName = "Id"))
    private List<Ingredients> ingredientsList = new ArrayList<>();

    public void addIngredient(Ingredients ingredient) {
        this.ingredientsList.add(ingredient);
        ingredient.getRecipes().add(this);
    }

    public void removeIngredient(long ingredientId) {
        Ingredients ingredient = this.ingredientsList.stream().filter(ingredients -> ingredients.getId() == ingredientId)
                .findFirst().orElseThrow();
        this.ingredientsList.remove(ingredient);
        ingredient.getRecipes().remove(this);
    }

}