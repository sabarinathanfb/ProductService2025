package com.link360.productservice2025.services;


import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService {
    @Override
    public String getAllCategories() {
        return "";
    }

    @Override
    public String getProductsInCategory(Long categoryId) {
        return "";
    }
}
