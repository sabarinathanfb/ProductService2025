package com.link360.productservice2025.Mapper;

import com.link360.productservice2025.dtos.ProductDto;
import com.link360.productservice2025.models.Category;
import com.link360.productservice2025.models.Product;

public class Mapper {

    public static Product toProduct(ProductDto productDto){

        Product product = new Product();
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setId(productDto.getId());
        product.setImageUrl(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());

        return product;
    }
}
