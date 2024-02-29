package com.example.suppliesmanagementtoolv1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class RecipesDto {
    private long id;
    private String name;
    private String description;
}
