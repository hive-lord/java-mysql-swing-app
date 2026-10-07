package com.javaproject.service;

import com.javaproject.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for Product business logic.
 * Contains validation, business rules, and orchestrates DAO operations.
 */
public interface ProductService {
    /**
     * Creates a new product.
     * @param name Product name
     * @param description Product description
     * @param sku Unique SKU
     * @param price Product price
     * @param quantityInStock Initial stock quantity
     * @param reorderLevel Reorder level threshold
     * @param category Product category
     * @return Created product
     * @throws ServiceException if validation fails or SKU exists
     */
    Product createProduct(String name, String description, String sku, BigDecimal price,
                          int quantityInStock, int reorderLevel, String category) throws ServiceException;

    /**
     * Updates product information.
     * @param productId Product ID
     * @param name New name (nullable)
     * @param description New description (nullable)
     * @param price New price (nullable)
     * @param reorderLevel New reorder level (nullable)
     * @param category New category (nullable)
     * @return Updated product
     * @throws ServiceException if validation fails or product not found
     */
    Product updateProduct(Long productId, String name, String description, BigDecimal price,
                          Integer reorderLevel, String category) throws ServiceException;

    /**
     * Adjusts product stock (sale or restock).
     * @param productId Product ID
     * @param quantityChange Positive for restock, negative for sale
     * @return Updated product
     * @throws ServiceException if product not found or insufficient stock
     */
    Product adjustStock(Long productId, int quantityChange) throws ServiceException;

    /**
     * Finds a product by ID.
     * @param productId Product ID
     * @return Optional containing product if found
     * @throws ServiceException if query fails
     */
    Optional<Product> findById(Long productId) throws ServiceException;

    /**
     * Finds a product by SKU.
     * @param sku Product SKU
     * @return Optional containing product if found
     * @throws ServiceException if query fails
     */
    Optional<Product> findBySku(String sku) throws ServiceException;

    /**
     * Gets all active products.
     * @return List of active products
     * @throws ServiceException if query fails
     */
    List<Product> getActiveProducts() throws ServiceException;

    /**
     * Gets all products in a category.
     * @param category Category name
     * @return List of products in category
     * @throws ServiceException if query fails
     */
    List<Product> getProductsByCategory(String category) throws ServiceException;

    /**
     * Gets all low stock products.
     * @return List of low stock products
     * @throws ServiceException if query fails
     */
    List<Product> getLowStockProducts() throws ServiceException;

    /**
     * Searches products by name.
     * @param namePart Partial name
     * @return List of matching products
     * @throws ServiceException if query fails
     */
    List<Product> searchProducts(String namePart) throws ServiceException;

    /**
     * Gets products within price range.
     * @param minPrice Minimum price
     * @param maxPrice Maximum price
     * @return List of products in range
     * @throws ServiceException if query fails
     */
    List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) throws ServiceException;

    /**
     * Discontinues a product (soft delete).
     * @param productId Product ID
     * @return true if discontinued
     * @throws ServiceException if product not found
     */
    boolean discontinueProduct(Long productId) throws ServiceException;

    /**
     * Reactivates a discontinued product.
     * @param productId Product ID
     * @return true if reactivated
     * @throws ServiceException if product not found
     */
    boolean reactivateProduct(Long productId) throws ServiceException;

    /**
     * Gets current stock quantity.
     * @param productId Product ID
     * @return Current quantity
     * @throws ServiceException if query fails
     */
    int getStockQuantity(Long productId) throws ServiceException;

    /**
     * Gets all distinct categories.
     * @return List of category names
     * @throws ServiceException if query fails
     */
    List<String> getAllCategories() throws ServiceException;
}