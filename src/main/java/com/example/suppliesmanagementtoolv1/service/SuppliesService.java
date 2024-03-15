package com.example.suppliesmanagementtoolv1.service;

import com.example.suppliesmanagementtoolv1.config.ResourceNotFoundException;
import com.example.suppliesmanagementtoolv1.model.Supplies;
import com.example.suppliesmanagementtoolv1.repository.SuppliesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuppliesService {

    private final SuppliesRepository suppliesRepository;

    @Cacheable(cacheNames = "AllSupplies")
    public List<Supplies> getAllSupplies(int page, int sizeNumber) {
        return suppliesRepository.findAllSupplies(PageRequest.of(page, sizeNumber));
    }

    @Cacheable(cacheNames = "SupplyById", key = "#id")
    public Supplies getSupplyById(long id) {
        return suppliesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supply not found with id: " + id)); // orElseThrow is required
    }

    @CacheEvict(cacheNames = "AllSupplies", allEntries = true)
    public List<Supplies> postSupplies(List<Supplies> suppliesList) {
        LocalDateTime currentTime = LocalDateTime.now();
        suppliesList.forEach(supply -> supply.setUpdated(currentTime));
        return suppliesRepository.saveAll(suppliesList);
    }

    @Transactional
    @CachePut(cacheNames = "SupplyById", key = "#result.id")
    @CacheEvict(cacheNames = "AllSupplies", allEntries = true)
    public Supplies putSupplies(Supplies editedSupply, Supplies supply) {
        LocalDateTime currentTime = LocalDateTime.now();
        editedSupply.setUpdated(currentTime);
        editedSupply.setName(supply.getName());
        editedSupply.setQuantity(supply.getQuantity());
        return suppliesRepository.save(editedSupply);
    }


    @CacheEvict(cacheNames = {"AllSupplies", "SupplyById"}, allEntries = true)
    public void deleteSupply(long id) {
        Supplies supply = suppliesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supply not found with id: " + id));
        suppliesRepository.deleteById(id);
    }

    public List<Supplies> getSuppliesByIds(List<Supplies> suppliesList) {
        List<Long> idsOfSupplies = suppliesList.stream()
                .map(Supplies::getId)
                .collect(Collectors.toList());
        return suppliesRepository.findAllById(idsOfSupplies);
    }

}
