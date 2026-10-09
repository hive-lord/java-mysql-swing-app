package com.javaproject.dao;

/**
 * Custom exception for Data Access Object layer operations.
 * Wraps underlying SQLException and provides context about the failed operation.
 *
 * <p>Every DAO method catches SQLException and rethrows DAOException with the
 * operation name (e.g. "save") and entity name (e.g. "User", "Product"/DriverFlag)
 * so the service layer can log and convert without parsing SQL states.</p>
 */
public class DAOException extends Exception {

    // TODO 1: `private String operation;` — e.g. "save", "findById", "updateStock".
    //   Set from every catch site: new DAOException("save failed", e, "save", "Product").

    // TODO 2: `private String entityName;` — e.g. "User", "Product".
    //   Lets logs read "DAO save failed for Product" instead of bare SQL codes.

    // TODO 3: Constructor `public DAOException(String message, Throwable cause,
    //   String operation, String entityName)`.
    //   1. super(message, cause); 2. this.operation = operation;
    //   3. this.entityName = entityName. Primary constructor — others delegate here.

    // TODO 4: Constructor `public DAOException(String message, Throwable cause)`.
    //   Delegates with operation="unknown", entityName="unknown". For quick wraps.

    // TODO 5: Constructor `public DAOException(String message)`.
    //   For validation failures inside DAO (e.g. "driver ID already exists")
    //   where there is no SQLException cause.

    // TODO 6: Getters `getOperation()` + `getEntityName()` (no setters — immutable context).

    // TODO 7: Override `public String getMessage()`.
    //   return super.getMessage() + " [operation=" + operation
    //       + ", entity=" + entityName + "]";
    //   Makes every log line self-describing.

    // TODO 8: Static factory `public static DAOException forSqlError(
    //   String operation, String entityName, SQLException e)`.
    //   Map common SQLStates/codes to readable messages:
    //   - 1062 / "23000" duplicate key -> "duplicate entry (driver ID / username taken)";
    //   - 1451/1452 FK violation       -> "referenced record missing / in use";
    //   - 40001 deadlock               -> "concurrent update, retry";
    //   Default: "database error". Keeps this mapping in ONE place.
}
