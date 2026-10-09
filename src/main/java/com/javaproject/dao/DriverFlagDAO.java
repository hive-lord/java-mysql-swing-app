package com.javaproject.dao;

import com.javaproject.model.DriverFlag;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for DriverFlag entity.
 * Defines flag-specific database operations beyond generic CRUD.
 */
public interface DriverFlagDAO extends GenericDAO<DriverFlag, Long> {
    /**
     * Finds a flag record by driver ID (case-insensitive).
     * @param driverId Driver ID to search for
     * @return Optional containing flag record if found
     * @throws DAOException if query fails
     */
    Optional<DriverFlag> findByDriverId(String driverId) throws DAOException;

    /**
     * Checks if a SKU already exists.
     * @param driverId Driver ID to check
     * @return true if Driver ID exists
     * @throws DAOException if query fails
     */
    boolean existsByDriverId(String driverId) throws DAOException;

    /**
     * Finds all flags of a specific event type.
     * @param eventType Event type to filter by
     * @return List of flags of the event type
     * @throws DAOException if query fails
     */
    List<DriverFlag> findByEventType(String eventType) throws DAOException;

    /**
     * Finds all open flag records.
     * @return List of open flag records
     * @throws DAOException if query fails
     */
    List<DriverFlag> findActiveFlags() throws DAOException;

    /**
     * Finds all flagged drivers (flag queue) (quantity <= flagThreshold).
     * @return List of flagged drivers
     * @throws DAOException if query fails
     */
    List<DriverFlag> findFlaggedDrivers() throws DAOException;

    /**
     * Searches flag records by partial label match.
     * @param labelPart Partial label to search for
     * @return List of matching flag records
     * @throws DAOException if query fails
     */
    List<DriverFlag> searchByLabel(String labelPart) throws DAOException;

    /**
     * Finds flags within a risk-score range.
     * @param minScore Minimum risk score (inclusive)
     * @param maxScore Maximum risk score (inclusive)
     * @return List of flags in score range
     * @throws DAOException if query fails
     */
    List<DriverFlag> findByRiskScoreRange(BigDecimal minScore, BigDecimal maxScore) throws DAOException;

    /**
     * Updates product event count (for resolutions/new eventing).
     * @param flagId DriverFlag ID
     * @param eventChange Positive for new event, negative for resolution
     * @return true if updated successfully
     * @throws DAOException if update fails or insufficient stock
     */
    boolean updateEventCount(Long flagId, int eventChange) throws DAOException;

    /**
     * Gets current event count for a product.
     * @param flagId DriverFlag ID
     * @return Current event count in stock
     * @throws DAOException if query fails
     */
    int getEventCount(Long flagId) throws DAOException;

    /**
     * Closes a flag record (soft close).
     * @param flagId DriverFlag ID
     * @return true if closed successfully
     * @throws DAOException if update fails
     */
    boolean closeFlag(Long flagId) throws DAOException;
}