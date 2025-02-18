package com.link360.productservice2025.services;

import com.link360.productservice2025.dtos.ProductDto;
import com.link360.productservice2025.exceptions.NotFoundException;
import com.link360.productservice2025.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DBProductService")
public class DBProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long productId) throws NotFoundException {
        return null;
    }

    @Override
    public Product addNewProduct(ProductDto product) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }
}
