package com.example.suppliesmanagementtoolv1.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RecipeDto {
    private String name;
    private String Description;
}