package com.example.suppliesmanagementtoolv1.controller;

import com.example.suppliesmanagementtoolv1.model.Supplies;
import com.example.suppliesmanagementtoolv1.service.SuppliesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Supplies> getSupplies(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) { // int -> Integer to avoid the null values for the parameters
        int pageNumber = page != null && page >=0 ? page : 0;
        int sizeNumber = size != null && size > 0 ? size : 20;
        return suppliesService.getAllSupplies(pageNumber, sizeNumber);
    }

    @GetMapping(path = "supplies/{id}")
    public Supplies getSingleSupplies(@PathVariable long id) {
        return suppliesService.getSuppliesById(id);
    }
}