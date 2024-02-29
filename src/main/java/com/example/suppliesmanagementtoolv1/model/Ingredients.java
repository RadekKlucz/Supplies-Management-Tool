package com.example.suppliesmanagementtoolv1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingredients {
    @Id
    private long id;
    private String name;
}
