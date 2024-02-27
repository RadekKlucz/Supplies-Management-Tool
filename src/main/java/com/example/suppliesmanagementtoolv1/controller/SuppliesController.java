package com.example.suppliesmanagementtoolv1.controller;

import com.example.suppliesmanagementtoolv1.model.Supplies;
import com.example.suppliesmanagementtoolv1.service.SuppliesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequiredArgsConstructor // it will create the constructor like below
public class SuppliesController {

    private final SuppliesService suppliesService;

    public SuppliesController(SuppliesService suppliesService) {
        this.suppliesService = suppliesService;
    }

    @GetMapping(path = "/supplies")
    public List<Supplies> getSupplies() {
        return suppliesService.getAllSupplies();
    }

    @GetMapping(path = "supplies/{id}")
    public Supplies getSingleSupplies(@PathVariable long id) {
        return suppliesService.getSuppliesById(id);
    }
}
