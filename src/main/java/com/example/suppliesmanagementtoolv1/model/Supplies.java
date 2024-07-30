package com.example.suppliesmanagementtoolv1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Supplies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long quantity;
    private LocalDateTime updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplies supplies = (Supplies) o;
        return Objects.equals(updated, supplies.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updated);
    }
}