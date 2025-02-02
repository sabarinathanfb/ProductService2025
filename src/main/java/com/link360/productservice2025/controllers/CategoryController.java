package com.link360.productservice2025.controllers;

import com.link360.productservice2025.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class CategoryController implements CategoryService {

    @GetMapping()
    public String getAllCategories(){
        return "Getting All Categories";
    }

    @GetMapping("/{categoryId}")
    public String getProductsInCategory(@PathVariable("categoryId") Long categoryId){
        return "Getting Products in Category";
    }
}
