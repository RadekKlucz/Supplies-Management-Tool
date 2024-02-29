package com.example.suppliesmanagementtoolv1.service;

import com.example.suppliesmanagementtoolv1.model.Supplies;
import com.example.suppliesmanagementtoolv1.repository.SuppliesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuppliesService {

//    private static final int SIZE_PAGE = 20;
    private final SuppliesRepository suppliesRepository;

    public List<Supplies> getAllSupplies(int page, int sizeNumber) {
        return suppliesRepository.findAllSupplies(PageRequest.of(page, sizeNumber));
    }

    public Supplies getSuppliesById(long id) {
        return suppliesRepository.findById(id).orElseThrow(); // orElseThrow is required
    }
}
