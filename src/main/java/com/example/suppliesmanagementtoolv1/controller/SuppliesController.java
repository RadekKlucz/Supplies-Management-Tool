package com.example.suppliesmanagementtoolv1.controller;

import com.example.suppliesmanagementtoolv1.model.Supplies;
import com.example.suppliesmanagementtoolv1.service.SuppliesService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequiredArgsConstructor // it will create the constructor like below
public class SuppliesController {

    private final SuppliesService suppliesService;

    public SuppliesController(SuppliesService suppliesService) {
        this.suppliesService = suppliesService;
    }

    @GetMapping(path = "/supplies")
    public List<Supplies> getAllSupplies(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) { // int -> Integer to avoid the null values for the parameters
        int pageNumber = page != null && page >=0 ? page : 0;
        int sizeNumber = size != null && size > 0 ? size : 20;
        return suppliesService.getAllSupplies(pageNumber, sizeNumber);
    }

    @GetMapping(path = "supplies/{id}")
    public Supplies getSingleSupply(@PathVariable long id) {
        return suppliesService.getSupplyById(id);
    }

    @PostMapping(path = "/supplies")
    public List<Supplies> postListOfSupplies(@RequestBody List<Supplies> suppliesList) {
//        List<Supplies> existingSupplies = suppliesService.getSuppliesByNames(suppliesList); // is it required?
        return suppliesService.postSupplies(suppliesList);
    }

    @PutMapping(path = "/supplies")
    public List<Supplies> editSupplies(@RequestBody List<Supplies> suppliesList) {
        List<Supplies> editedSupplies = suppliesService.getSuppliesByIds(suppliesList);
        List<Supplies> result = new ArrayList<>();
        for (Supplies supply: suppliesList) {
            for (Supplies editedSupply: editedSupplies) {
                if(supply.getId() == editedSupply.getId()) { // pozostale controllery do poprawy w taki sam sposob
                    result.add(suppliesService.putSupplies(editedSupply, supply));
                }
            }
        }
        return result;
    }

    @DeleteMapping(path = "supplies/{id}")
    public ResponseEntity<Object> deleteSupply(@PathVariable long id) {
        suppliesService.deleteSupply(id);
        return ResponseEntity.ok("Supply with " + id + " has been deleted.");
    }
}
