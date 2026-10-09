package com.javaproject.service;

import com.javaproject.model.Reviewer;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for Reviewer business logic.
 * Contains validation, business rules, and orchestrates DAO operations.
 */
public interface ReviewerService {
    /**
     * Registers a new reviewer.
     * Validates input, hashes password, saves to database.
     * @param username Unique username
     * @param email Unique email
     * @param password Plain text password (will be hashed)
     * @param firstName Reviewer's first name
     * @param lastName Reviewer's last name
     * @return Created reviewer
     * @throws ServiceException if validation fails or reviewer already exists
     */
    Reviewer registerReviewer(String username, String email, String password, String firstName, String lastName) throws ServiceException;

    /**
     * Authenticates a reviewer with username and password.
     * @param username Username or email
     * @param password Plain text password
     * @return Optional containing authenticated reviewer if credentials valid
     * @throws ServiceException if authentication error
     */
    Optional<Reviewer> authenticate(String username, String password) throws ServiceException;

    /**
     * Updates reviewer profile information.
     * @param reviewerId Reviewer ID
     * @param firstName New first name (nullable)
     * @param lastName New last name (nullable)
     * @param phoneNumber New phone number (nullable)
     * @param email New email (nullable, must be unique)
     * @return Updated reviewer
     * @throws ServiceException if validation fails or reviewer not found
     */
    Reviewer updateProfile(Long reviewerId, String firstName, String lastName, String phoneNumber, String email) throws ServiceException;

    /**
     * Changes reviewer's password.
     * @param reviewerId Reviewer ID
     * @param currentPassword Current plain text password
     * @param newPassword New plain text password
     * @return true if changed successfully
     * @throws ServiceException if validation fails or current password incorrect
     */
    boolean changePassword(Long reviewerId, String currentPassword, String newPassword) throws ServiceException;

    /**
     * Finds a reviewer by ID.
     * @param reviewerId Reviewer ID
     * @return Optional containing reviewer if found
     * @throws ServiceException if query fails
     */
    Optional<Reviewer> findById(Long reviewerId) throws ServiceException;

    /**
     * Finds a reviewer by username.
     * @param username Username
     * @return Optional containing reviewer if found
     * @throws ServiceException if query fails
     */
    Optional<Reviewer> findByUsername(String username) throws ServiceException;

    /**
     * Gets all active reviewers.
     * @return List of active reviewers
     * @throws ServiceException if query fails
     */
    List<Reviewer> getActiveReviewers() throws ServiceException;

    /**
     * Gets all reviewers with a specific role.
     * @param role Reviewer role
     * @return List of reviewers with role
     * @throws ServiceException if query fails
     */
    List<Reviewer> getReviewersByRole(Reviewer.ReviewerRole role) throws ServiceException;

    /**
     * Searches reviewers by name.
     * @param namePart Partial name
     * @return List of matching reviewers
     * @throws ServiceException if query fails
     */
    List<Reviewer> searchReviewers(String namePart) throws ServiceException;

    /**
     * Deactivates a reviewer (soft close).
     * @param reviewerId Reviewer ID
     * @return true if deactivated
     * @throws ServiceException if reviewer not found
     */
    boolean deactivateReviewer(Long reviewerId) throws ServiceException;

    /**
     * Activates a reviewer.
     * @param reviewerId Reviewer ID
     * @return true if activated
     * @throws ServiceException if reviewer not found
     */
    boolean activateReviewer(Long reviewerId) throws ServiceException;

    /**
     * Changes reviewer's role (admin only).
     * @param reviewerId Reviewer ID
     * @param newRole New role
     * @return Updated reviewer
     * @throws ServiceException if reviewer not found or invalid role
     */
    Reviewer changeReviewerRole(Long reviewerId, Reviewer.ReviewerRole newRole) throws ServiceException;
}