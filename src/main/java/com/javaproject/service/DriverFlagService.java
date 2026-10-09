package com.javaproject.service;

import com.javaproject.model.DriverFlag;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for DriverFlag business logic.
 * Contains validation, business rules, and orchestrates DAO operations.
 */
public interface DriverFlagService {
    /**
     * Creates a new product.
     * @param label DriverFlag name
     * @param summary DriverFlag summary
     * @param driverId Unique driver ID
     * @param riskScore Risk score
     * @param eventCount Initial event count
     * @param flagThreshold Flag-threshold count
     * @param eventType Event type
     * @return Created flag record
     * @throws ServiceException if validation fails or Driver ID exists
     */
    DriverFlag createFlagRecord(String label, String summary, String driverId, BigDecimal riskScore,
                          int eventCount, int flagThreshold, String eventType) throws ServiceException;

    /**
     * Updates product information.
     * @param flagId DriverFlag ID
     * @param label New name (nullable)
     * @param summary New summary (nullable)
     * @param riskScore New risk score (nullable)
     * @param flagThreshold New flag threshold (nullable)
     * @param eventType New event type (nullable)
     * @return Updated flag record
     * @throws ServiceException if validation fails or flag record not found
     */
    DriverFlag updateFlagRecord(Long flagId, String label, String summary, BigDecimal riskScore,
                          Integer flagThreshold, String eventType) throws ServiceException;

    /**
     * Adjusts event count (event ingest or resolution).
     * @param flagId DriverFlag ID
     * @param eventChange Positive for new event, negative for resolution
     * @return Updated flag record
     * @throws ServiceException if flag record not found or insufficient stock
     */
    DriverFlag recordEvent(Long flagId, int eventChange) throws ServiceException;

    /**
     * Finds a flag record by ID.
     * @param flagId DriverFlag ID
     * @return Optional containing flag record if found
     * @throws ServiceException if query fails
     */
    Optional<DriverFlag> findById(Long flagId) throws ServiceException;

    /**
     * Finds a flag record by driver ID.
     * @param driverId Driver ID
     * @return Optional containing flag record if found
     * @throws ServiceException if query fails
     */
    Optional<DriverFlag> findByDriverId(String driverId) throws ServiceException;

    /**
     * Gets all open flag records.
     * @return List of open flag records
     * @throws ServiceException if query fails
     */
    List<DriverFlag> getActiveFlags() throws ServiceException;

    /**
     * Gets all flags of an event type.
     * @param eventType Event-type name
     * @return List of flags in event type
     * @throws ServiceException if query fails
     */
    List<DriverFlag> getFlagsByEventType(String eventType) throws ServiceException;

    /**
     * Gets the flag queue (all flagged drivers).
     * @return List of flagged drivers
     * @throws ServiceException if query fails
     */
    List<DriverFlag> getFlagQueue() throws ServiceException;

    /**
     * Searches flag records by label.
     * @param labelPart Partial label
     * @return List of matching flag records
     * @throws ServiceException if query fails
     */
    List<DriverFlag> searchFlags(String labelPart) throws ServiceException;

    /**
     * Gets flags within a risk-score range.
     * @param minScore Minimum risk score
     * @param maxScore Maximum risk score
     * @return List of flags in score range
     * @throws ServiceException if query fails
     */
    List<DriverFlag> getFlagsByRiskScoreRange(BigDecimal minScore, BigDecimal maxScore) throws ServiceException;

    /**
     * Closes a flag record (soft close).
     * @param flagId DriverFlag ID
     * @return true if closed
     * @throws ServiceException if flag record not found
     */
    boolean closeFlag(Long flagId) throws ServiceException;

    /**
     * Reactivates a closed flag.
     * @param flagId DriverFlag ID
     * @return true if reopend
     * @throws ServiceException if flag record not found
     */
    boolean reopenFlag(Long flagId) throws ServiceException;

    /**
     * Gets current event count.
     * @param flagId DriverFlag ID
     * @return Current event count
     * @throws ServiceException if query fails
     */
    int getEventCount(Long flagId) throws ServiceException;

    /**
     * Gets all distinct event types.
     * @return List of event-type names
     * @throws ServiceException if query fails
     */
    List<String> getAllEventTypes() throws ServiceException;
}