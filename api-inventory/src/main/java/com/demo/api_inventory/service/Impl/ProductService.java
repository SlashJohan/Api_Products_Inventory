package com.demo.api_inventory.service.Impl;

import com.demo.api_inventory.dto.product.Product;
import com.demo.api_inventory.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final RestTemplate restTemplate;

    @Override
    public Optional<Product> getProductById(Long id) {
        String productApiBaseUrl = "http://localhost:8080/api/v1";
        String url = productApiBaseUrl + "/products/" + id;

        try {
            Product product = restTemplate.getForObject(url, Product.class);
            return Optional.ofNullable(product);
        } catch (RestClientException e) {
            System.out.println("Error Get Product by ID " + id);
            return Optional.empty();
        }
    }

}
