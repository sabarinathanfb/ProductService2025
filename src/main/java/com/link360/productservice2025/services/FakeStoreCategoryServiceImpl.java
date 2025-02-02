package com.link360.productservice2025.services;


import com.link360.productservice2025.Mapper.Mapper;
import com.link360.productservice2025.dtos.FakeStoreProductDto;
import com.link360.productservice2025.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService {

    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder ) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<String> getAllCategories() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<String[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String[].class
        );


        return Arrays.asList(response.getBody());
    }

    @Override
    public List<Product> getProductsInCategory(String categoryName) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/category/{categoryName}",
                FakeStoreProductDto[].class,
                categoryName
        );

        List<Product> answer = new ArrayList<>();

        for (FakeStoreProductDto productDto : response.getBody()) {
            answer.add(Mapper.convertFakseStoreProductDtoToProduct(productDto));
        }
        return answer;

    }
}
