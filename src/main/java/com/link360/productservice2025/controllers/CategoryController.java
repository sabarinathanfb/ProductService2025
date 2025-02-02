package com.link360.productservice2025.controllers;

import com.link360.productservice2025.dtos.ProductDto;
import com.link360.productservice2025.models.Product;
import com.link360.productservice2025.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<String>> getAllCategories(){

        List<String> categories = categoryService.getAllCategories();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Product>> getProductsInCategory(@PathVariable("categoryName") String categoryName){

        List<Product> products = categoryService.getProductsInCategory(categoryName);


        return new ResponseEntity<>(products,  HttpStatus.OK);
    }
}
