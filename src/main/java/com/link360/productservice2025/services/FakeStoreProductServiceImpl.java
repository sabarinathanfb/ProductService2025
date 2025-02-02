package com.link360.productservice2025.services;

import org.springframework.lang.Nullable;
import com.link360.productservice2025.Mapper.Mapper;
import com.link360.productservice2025.dtos.FakeStoreProductDto;
import com.link360.productservice2025.dtos.ProductDto;
import com.link360.productservice2025.models.Category;
import com.link360.productservice2025.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private final RestTemplateBuilder restTemplateBuilder;


    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();

        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> l = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        List<Product> answer = new ArrayList<>();

        for (FakeStoreProductDto productDto : l.getBody()) {
            answer.add(Mapper.convertFakseStoreProductDtoToProduct(productDto));

        }


        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.
                getForEntity(
                        "https://fakestoreapi.com/products/{id}",
                        FakeStoreProductDto.class,
                        productId
                );
        return Mapper.convertFakseStoreProductDtoToProduct(response.getBody());

    }

    @Override
    public Product addNewProduct(ProductDto product) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                FakeStoreProductDto.class
        );


        return Mapper.convertFakseStoreProductDtoToProduct(response.getBody());
    }


    @Override
    public Product updateProduct(Long productId, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();

//        // Send the PATCH request and get the updated ProductDto
//        FakeStoreProductDto updatedProductDto = restTemplate.patchForObject(
//                "https://fakestoreapi.com/products/{id}",
//                Mapper.toProductDto(product),
//                FakeStoreProductDto.class,
//                productId
//        );
        ResponseEntity<FakeStoreProductDto> response = requestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                Mapper.convertProductToFakeStoreProductDto(product),
                FakeStoreProductDto.class,
                productId
        );


        // Map the ProductDto back to Product and return it
        return Mapper.convertFakseStoreProductDtoToProduct(response.getBody());
    }


    @Override
    public Product deleteProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();

        ResponseEntity<FakeStoreProductDto> response = requestForEntity(
                HttpMethod.DELETE,
                "https://fakestoreapi.com/products/{id}",
                null,
                FakeStoreProductDto.class,
                productId
        );

        return Mapper.convertFakseStoreProductDtoToProduct(response.getBody());

    }

}
