package com.link360.productservice2025.controllers;


import com.link360.productservice2025.Mapper.Mapper;
import com.link360.productservice2025.dtos.ErrorResponseDto;
import com.link360.productservice2025.dtos.ProductDto;
import com.link360.productservice2025.exceptions.NotFoundException;
import com.link360.productservice2025.models.Product;
import com.link360.productservice2025.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException {

        Optional<Product> productOptional = Optional.ofNullable(productService.getSingleProduct(productId));

        if(productOptional.isEmpty()){
            throw new NotFoundException("No Product With id product id" + productId);
        }



        return new ResponseEntity<>(
                productService.getSingleProduct(productId),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<ProductDto> addNewProduct(@RequestBody ProductDto productDto) {


        // Return the created product with HTTP 201 (Created)
        return new ResponseEntity<>(Mapper.toProductDto(productService.addNewProduct(productDto)), HttpStatus.CREATED);
    }


    @PatchMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto){

        return new ResponseEntity<>(Mapper.toProductDto(productService.updateProduct(productId, Mapper.toProduct(productDto))), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable("productId") Long productId) {

        return new ResponseEntity<>(Mapper.toProductDto(productService.deleteProduct(productId)), HttpStatus.OK);

    }



}
