package com.link360.productservice2025.services;

import com.link360.productservice2025.Mapper.Mapper;
import com.link360.productservice2025.dtos.ProductDto;
import com.link360.productservice2025.models.Category;
import com.link360.productservice2025.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {



    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long productId) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response = restTemplate.
                getForEntity(
                        "https://fakestoreapi.com/products/{id}",
                        ProductDto.class,
                        productId
                );

        ProductDto productDto = response.getBody();



        return Mapper.toProduct(productDto);

    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}
