package com.example.suppliesmanagementtoolv1.service;

import com.example.suppliesmanagementtoolv1.model.Supplies;
import com.example.suppliesmanagementtoolv1.repository.SuppliesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuppliesService {
    private final SuppliesRepository suppliesRepository;
    public List<Supplies> getAllSupplies() {
        return suppliesRepository.findAll();
    }

    public Supplies getSuppliesById(long id) {
        return suppliesRepository.findById(id).orElseThrow(); // orElseThrow is required
    }
}
