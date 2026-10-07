package com.javaproject.model;

/**
 * Product entity representing a product in the inventory system.
 * Maps to the 'products' table in MySQL database.
 * TODO: Add @Table(name = "products") annotation if using JPA
 */
public class Product extends BaseEntity {
    // TODO: Add private String name field (not null)
    // TODO: Add private String description field
    // TODO: Add private String sku field (unique, not null) - Stock Keeping Unit
    // TODO: Add private BigDecimal price field (not null, precision 10, scale 2)
    // TODO: Add private Integer quantityInStock field (not null, default 0)
    // TODO: Add private Integer reorderLevel field (default 10)
    // TODO: Add private String category field
    // TODO: Add private boolean active field (default true)
    // TODO: Add private LocalDateTime discontinuedAt field (nullable)
    // TODO: Generate constructor with required fields (name, sku, price)
    // TODO: Generate getters and setters for all fields
    // TODO: Add helper method isLowStock() returning quantityInStock <= reorderLevel
    // TODO: Add helper method isAvailable() returning active && quantityInStock > 0
    // TODO: Override toString() for debugging
}