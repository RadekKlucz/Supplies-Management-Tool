package com.example.suppliesmanagementtoolv1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Supplies {
    @Id
    private long id;
    private String name;
    private long quantity;
    private LocalDateTime updated;
}