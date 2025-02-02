package com.link360.productservice2025.services;


import com.link360.productservice2025.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getSingleProduct(Long productId);
    Product addNewProduct(Product product);
    Product updateProduct(Long productId, Product product);
    boolean deleteProduct( Long productId);
}
