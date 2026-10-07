package com.javaproject.service;

import com.javaproject.dao.ProductDAO;
import com.javaproject.model.Product;
import com.javaproject.util.PriceUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of ProductService.
 * Handles validation, business rules, and DAO orchestration.
 */
public class ProductServiceImpl implements ProductService {
    // TODO: Add private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class)
    // TODO: Add private final ProductDAO productDAO field
    // TODO: Add private final PriceUtil priceUtil field (for price calculations, rounding)
    // TODO: Add constructor accepting ProductDAO and PriceUtil

    @Override
    public Product createProduct(String name, String description, String sku, BigDecimal price,
                                 int quantityInStock, int reorderLevel, String category) throws ServiceException {
        // TODO: Validate name not null/empty
        // TODO: Validate sku not null/empty
        // TODO: Validate price not null and > 0
        // TODO: Validate quantityInStock >= 0
        // TODO: Validate reorderLevel >= 0
        // TODO: Validate category not null/empty
        // TODO: Check if SKU already exists using productDAO.existsBySku()
        // TODO: Create new Product entity, set fields, active true
        // TODO: Save using productDAO.save()
        // TODO: Log creation
        // TODO: Return created product
        // TODO: Catch DAOException and wrap in ServiceException
        return null; // Remove after implementation
    }

    @Override
    public Product updateProduct(Long productId, String name, String description, BigDecimal price,
                               Integer reorderLevel, String category) throws ServiceException {
        // TODO: Validate productId not null
        // TODO: Find existing product using productDAO.findById()
        // TODO: If not found, throw ServiceException
        // TODO: Update fields if non-null (name, description, price, reorderLevel, category)
        // TODO: Validate updated fields (e.g., price > 0)
        // TODO: Save using productDAO.update()
        // TODO: Log update
        // TODO: Return updated product
        // TODO: Catch DAOException and wrap in ServiceException
        return null; // Remove after implementation
    }

    @Override
    public Product adjustStock(Long productId, int quantityChange) throws ServiceException {
        // TODO: Validate productId not null
        // TODO: Use productDAO.updateStock(productId, quantityChange)
        // TODO: If update fails (e.g., insufficient stock), throw ServiceException
        // TODO: Retrieve updated product using findById()
        // TODO: Log stock adjustment
        // TODO: Return updated product
        // TODO: Catch DAOException and wrap in ServiceException
        return null; // Remove after implementation
    }

    @Override
    public Optional<Product> findById(Long productId) throws ServiceException {
        // TODO: Validate productId
        // TODO: Call productDAO.findById()
        // TODO: Catch DAOException and wrap in ServiceException
        return Optional.empty(); // Remove after implementation
    }

    @Override
    public Optional<Product> findBySku(String sku) throws ServiceException {
        // TODO: Validate sku
        // TODO: Call productDAO.findBySku()
        // TODO: Catch DAOException and wrap in ServiceException
        return Optional.empty(); // Remove after implementation
    }

    @Override
    public List<Product> getActiveProducts() throws ServiceException {
        // TODO: Call productDAO.findActiveProducts()
        // TODO: Catch DAOException and wrap in ServiceException
        return List.of(); // Remove after implementation
    }

    @Override
    public List<Product> getProductsByCategory(String category) throws ServiceException {
        // TODO: Validate category
        // TODO: Call productDAO.findByCategory(category)
        // TODO: Catch DAOException and wrap in ServiceException
        return List.of(); // Remove after implementation
    }

    @Override
    public List<Product> getLowStockProducts() throws ServiceException {
        // TODO: Call productDAO.findLowStockProducts()
        // TODO: Catch DAOException and wrap in ServiceException
        return List.of(); // Remove after implementation
    }

    @Override
    public List<Product> searchProducts(String namePart) throws ServiceException {
        // TODO: Validate namePart not null/empty
        // TODO: Call productDAO.searchByName(namePart)
        // TODO: Catch DAOException and wrap in ServiceException
        return List.of(); // Remove after implementation
    }

    @Override
    public List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) throws ServiceException {
        // TODO: Validate minPrice and maxPrice not null and minPrice <= maxPrice
        // TODO: Call productDAO.findByPriceRange(minPrice, maxPrice)
        // TODO: Catch DAOException and wrap in ServiceException
        return List.of(); // Remove after implementation
    }

    @Override
    public boolean discontinueProduct(Long productId) throws ServiceException {
        // TODO: Validate productId
        // TODO: Call productDAO.discontinueProduct(productId)
        // TODO: Log discontinuation
        // TODO: Return true if successful
        // TODO: Catch DAOException and wrap in ServiceException
        return false; // Remove after implementation
    }

    @Override
    public boolean reactivateProduct(Long productId) throws ServiceException {
        // TODO: Validate productId
        // TODO: Implement reactivation (set active=true, clear discontinuedAt)
        // TODO: Update using productDAO.update()
        // TODO: Log reactivation
        // TODO: Return true if successful
        // TODO: Catch DAOException and wrap in ServiceException
        return false; // Remove after implementation
    }

    @Override
    public int getStockQuantity(Long productId) throws ServiceException {
        // TODO: Validate productId
        // TODO: Call productDAO.getStockQuantity(productId)
        // TODO: Catch DAOException and wrap in ServiceException
        return 0; // Remove after implementation
    }

    @Override
    public List<String> getAllCategories() throws ServiceException {
        // TODO: Query distinct categories from products table
        // TODO: Use productDAO (add method if needed) or direct JDBC query
        // TODO: Return category list
        // TODO: Catch SQLException and wrap in ServiceException
        return List.of(); // Remove after implementation
    }

    // TODO: Add private void validatePrice(BigDecimal price) throws ServiceException helper
    // TODO: Add private void validateSku(String sku) throws ServiceException helper
    // TODO: Add private void validateQuantity(int qty) throws ServiceException helper
    // TODO: Add private void validateReorderLevel(int level) throws ServiceException helper
}