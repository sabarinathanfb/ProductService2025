package com.link360.productservice2025.controllers;


import com.link360.productservice2025.dtos.GetSingleProductResponseDto;
import com.link360.productservice2025.dtos.ProductDto;
import com.link360.productservice2025.models.Product;
import com.link360.productservice2025.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getAllProducts(){
        return "Getting All Products";
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetSingleProductResponseDto> getSingleProduct(@PathVariable("productId") Long productId){

        GetSingleProductResponseDto responseDto = new GetSingleProductResponseDto();
        responseDto.setProduct(productService.getSingleProduct(productId));

        return new ResponseEntity<>(
                responseDto,
                HttpStatus.OK
        );
    }

    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto productDto) {
        return "Adding new product " + productDto;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId){
        return "Updating Product with productId: "  + productId;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting Product with productId: " + productId;
    }
}
