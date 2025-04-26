package com.demo.api_inventory.dto.inventory;

import com.demo.api_inventory.dto.product.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class InventoryResponseDto {
    Long id;
    Product product;
    Integer amount;

}
