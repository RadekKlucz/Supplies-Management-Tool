package com.example.suppliesmanagementtoolv1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Supplies {
    @Id
    private long Id;
    private String Name;
    private long Quantity;
    private LocalDateTime Updated;
}