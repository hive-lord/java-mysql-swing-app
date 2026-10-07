package com.javaproject.dao;

import com.javaproject.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for Product entity.
 * Defines product-specific database operations beyond generic CRUD.
 */
public interface ProductDAO extends GenericDAO<Product, Long> {
    /**
     * Finds a product by SKU (case-insensitive).
     * @param sku SKU to search for
     * @return Optional containing product if found
     * @throws DAOException if query fails
     */
    Optional<Product> findBySku(String sku) throws DAOException;

    /**
     * Checks if a SKU already exists.
     * @param sku SKU to check
     * @return true if SKU exists
     * @throws DAOException if query fails
     */
    boolean existsBySku(String sku) throws DAOException;

    /**
     * Finds all products in a specific category.
     * @param category Category to filter by
     * @return List of products in the category
     * @throws DAOException if query fails
     */
    List<Product> findByCategory(String category) throws DAOException;

    /**
     * Finds all active products.
     * @return List of active products
     * @throws DAOException if query fails
     */
    List<Product> findActiveProducts() throws DAOException;

    /**
     * Finds all products with low stock (quantity <= reorderLevel).
     * @return List of low stock products
     * @throws DAOException if query fails
     */
    List<Product> findLowStockProducts() throws DAOException;

    /**
     * Searches products by partial name match.
     * @param namePart Partial name to search for
     * @return List of matching products
     * @throws DAOException if query fails
     */
    List<Product> searchByName(String namePart) throws DAOException;

    /**
     * Finds products within a price range.
     * @param minPrice Minimum price (inclusive)
     * @param maxPrice Maximum price (inclusive)
     * @return List of products in price range
     * @throws DAOException if query fails
     */
    List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) throws DAOException;

    /**
     * Updates product stock quantity (for sales/restocking).
     * @param productId Product ID
     * @param quantityChange Positive for restock, negative for sale
     * @return true if updated successfully
     * @throws DAOException if update fails or insufficient stock
     */
    boolean updateStock(Long productId, int quantityChange) throws DAOException;

    /**
     * Gets current stock quantity for a product.
     * @param productId Product ID
     * @return Current quantity in stock
     * @throws DAOException if query fails
     */
    int getStockQuantity(Long productId) throws DAOException;

    /**
     * Discontinues a product (soft delete).
     * @param productId Product ID
     * @return true if discontinued successfully
     * @throws DAOException if update fails
     */
    boolean discontinueProduct(Long productId) throws DAOException;
}