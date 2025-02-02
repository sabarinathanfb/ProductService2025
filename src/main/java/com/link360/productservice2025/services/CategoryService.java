package com.link360.productservice2025.services;

import com.link360.productservice2025.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryService {

    List<String> getAllCategories();
    List<Product> getProductsInCategory(String categoryName);
}
