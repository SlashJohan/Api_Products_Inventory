package com.productos.demo_productos.service;

import com.productos.demo_productos.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getProducts();

    Page<Product> getProductsPaginated(int page, int size);

    Product addProduct(Product product);

    Product getProductById(Long id);

    Product updateProduct(Long id, Product updatedProduct);

    boolean deleteProduct(Long id);
}
