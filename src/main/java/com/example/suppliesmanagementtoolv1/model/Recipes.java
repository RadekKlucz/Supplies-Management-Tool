package com.example.suppliesmanagementtoolv1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Recipes {
    @Id
    private long id;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name = "Recipes_Ingredients", joinColumns = @JoinColumn(name = "Recipe_Id",
    referencedColumnName = "Id"), inverseJoinColumns = @JoinColumn(name = "Ingredients_Id",
    referencedColumnName = "Id"))
    private List<Ingredients> ingredientsList;
}