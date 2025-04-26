package com.demo.api_inventory.service;


import com.demo.api_inventory.dto.inventory.InventoryResponseDto;

public interface IInventoryService {
    InventoryResponseDto getInventory(Long productId);
    InventoryResponseDto buyProduct(Long productId, Integer amount);
}
