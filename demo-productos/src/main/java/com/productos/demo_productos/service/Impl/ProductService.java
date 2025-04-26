package com.productos.demo_productos.service.Impl;

import com.productos.demo_productos.entity.Product;
import com.productos.demo_productos.repository.IProductRepository;
import com.productos.demo_productos.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    // Listar todos los productos
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // Listar productos con paginación simple
    @Override
    public Page<Product> getProductsPaginated(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    // Crear producto
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Obtener producto por ID
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElse(null);
    }

    // Actualizar producto por ID
    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setPrice(updatedProduct.getPrice());
                    product.setAntique(updatedProduct.getAntique());
                    return product;
                }).map(productRepository::save)
                .orElseGet(null);
    }

    // Eliminar producto por ID
    @Override
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
