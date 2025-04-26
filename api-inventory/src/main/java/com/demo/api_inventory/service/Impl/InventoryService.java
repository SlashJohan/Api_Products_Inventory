package com.demo.api_inventory.service.Impl;

import com.demo.api_inventory.dto.inventory.InventoryResponseDto;
import com.demo.api_inventory.dto.product.Product;
import com.demo.api_inventory.entity.Inventory;
import com.demo.api_inventory.repository.InventoryRepository;
import com.demo.api_inventory.service.IInventoryService;
import com.demo.api_inventory.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class InventoryService implements IInventoryService {

    private final InventoryRepository inventoryRepository;
    private final IProductService productService;

    @Override
    public InventoryResponseDto getInventory(Long productId) {
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Error find product by ID: " + productId));

        Inventory inventory = inventoryRepository.findByProductId(product.getId())
                .orElseThrow(() -> new RuntimeException("Error find inventory by productId"));

        return InventoryResponseDto.builder()
                .id(inventory.getId())
                .product(product)
                .amount(inventory.getAmount())
                .build();

    }

    @Override
    public InventoryResponseDto buyProduct(Long productId, Integer amount) {

        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Error find product by ID: " + productId));

        Inventory inv = inventoryRepository.findByProductId(product.getId())
                .orElseThrow(() -> new RuntimeException("Error find inventory by productId"));

        if (inv.getAmount() < amount) {
            throw new RuntimeException("The requested quantity is not available");
        }

        inv.setAmount(inv.getAmount() - amount);
        Inventory updated = inventoryRepository.save(inv);

        System.out.println("Update inventory by product ID:" + productId +
                ", Inventory:" + updated.toString());

        return InventoryResponseDto.builder()
                .id(updated.getId())
                .product(product)
                .amount(updated.getAmount())
                .build();
    }
}
