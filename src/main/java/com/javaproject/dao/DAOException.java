package com.javaproject.dao;

/**
 * Custom exception for Data Access Object layer operations.
 * Wraps underlying SQLException and provides context about the failed operation.
 */
public class DAOException extends Exception {
    // TODO: Add private String operation field (e.g., "save", "findById", "update")
    // TODO: Add private String entityName field (e.g., "User", "Product")
    // TODO: Add constructor with message, cause, operation, and entityName
    // TODO: Add constructor with message and cause
    // TODO: Add constructor with message only
    // TODO: Add getter for operation
    // TODO: Add getter for entityName
    // TODO: Override getMessage() to include operation and entity context
    // TODO: Add static factory method for common SQL error codes (duplicate key, foreign key, etc.)
}