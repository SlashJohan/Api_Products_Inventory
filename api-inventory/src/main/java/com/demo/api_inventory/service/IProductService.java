package com.demo.api_inventory.service;

import com.demo.api_inventory.dto.product.Product;

import java.util.Optional;

public interface IProductService {

    Optional<Product> getProductById(Long id);

}
