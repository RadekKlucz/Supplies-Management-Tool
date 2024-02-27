package com.example.suppliesmanagementtoolv1.repository;

import com.example.suppliesmanagementtoolv1.model.Supplies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliesRepository extends JpaRepository<Supplies, Long> {}