package com.link360.productservice2025.Mapper;

import com.link360.productservice2025.dtos.FakeStoreProductDto;
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
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());

        return product;
    }

    public static ProductDto toProductDto(Product product){

        if(product == null){
            return null;
        }
        ProductDto productDto = new ProductDto();

        productDto.setDescription(product.getDescription());
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        productDto.setImage(product.getImageUrl());
        productDto.setCategory(product.getCategory().getName());

        return productDto;

    }

    public static Product convertFakseStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();

        product.setDescription(fakeStoreProductDto.getDescription());
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(fakeStoreProductDto.getImage());
        return product;
    }

    public static FakeStoreProductDto convertProductToFakeStoreProductDto(Product product){

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setImage(product.getImageUrl());
        return fakeStoreProductDto;
    }


}
