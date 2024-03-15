package com.example.suppliesmanagementtoolv1.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RecipesDto {
    private long id;
    private String name;
    private String description;
}
