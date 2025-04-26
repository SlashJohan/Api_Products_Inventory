package com.productos.demo_productos.controller;

import com.productos.demo_productos.entity.Product;
import com.productos.demo_productos.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private  final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getOne(@PathVariable Long productId) {
        return ResponseEntity.ok()
                .body(productService.getProductById(productId));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.addProduct(product));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> update(
            @PathVariable Long productId,
            @RequestBody Product product) {
        return ResponseEntity.ok()
                .body(productService.updateProduct(productId, product));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
