package com.demo.api_inventory.controller;

import com.demo.api_inventory.dto.inventory.InventoryResponseDto;
import com.demo.api_inventory.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired
    private IInventoryService service;

    @GetMapping("/{productId}/products")
    public ResponseEntity<InventoryResponseDto> get(@PathVariable Long productId) {
        return ResponseEntity.ok(service.getInventory(productId));
    }

    @PostMapping("/{productId}/products/{amount}/amount")
    public ResponseEntity<InventoryResponseDto> buyProduct(
            @PathVariable Long productId,
            @PathVariable Integer amount) {
        InventoryResponseDto updated = service.buyProduct(productId, amount);
        return ResponseEntity.ok(updated);
    }
}
