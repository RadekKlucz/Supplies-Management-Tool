package com.example.suppliesmanagementtoolv1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Getter
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST},
            mappedBy = "ingredientsList")
    @JsonIgnore
    private Set<Recipes> recipes = new HashSet<>();
}