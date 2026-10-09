package com.javaproject.dao;

import com.javaproject.model.Reviewer;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for Reviewer entity.
 * Defines reviewer-specific database operations beyond generic CRUD.
 */
public interface ReviewerDAO extends GenericDAO<Reviewer, Long> {
    /**
     * Finds a reviewer by username (case-insensitive).
     * @param username Username to search for
     * @return Optional containing reviewer if found
     * @throws DAOException if query fails
     */
    Optional<Reviewer> findByUsername(String username) throws DAOException;

    /**
     * Finds a reviewer by email (case-insensitive).
     * @param email Email to search for
     * @return Optional containing reviewer if found
     * @throws DAOException if query fails
     */
    Optional<Reviewer> findByEmail(String email) throws DAOException;

    /**
     * Checks if a username already exists.
     * @param username Username to check
     * @return true if username exists
     * @throws DAOException if query fails
     */
    boolean existsByUsername(String username) throws DAOException;

    /**
     * Checks if an email already exists.
     * @param email Email to check
     * @return true if email exists
     * @throws DAOException if query fails
     */
    boolean existsByEmail(String email) throws DAOException;

    /**
     * Finds all reviewers with a specific role.
     * @param role Reviewer role to filter by
     * @return List of reviewers with the given role
     * @throws DAOException if query fails
     */
    List<Reviewer> findByRole(Reviewer.ReviewerRole role) throws DAOException;

    /**
     * Finds all active reviewers.
     * @return List of active reviewers
     * @throws DAOException if query fails
     */
    List<Reviewer> findActiveReviewers() throws DAOException;

    /**
     * Updates reviewer's last login timestamp.
     * @param reviewerId Reviewer ID
     * @param loginTime Login timestamp
     * @return true if updated successfully
     * @throws DAOException if update fails
     */
    boolean updateLastLogin(Long reviewerId, java.time.LocalDateTime loginTime) throws DAOException;

    /**
     * Searches reviewers by partial name match (first or last name).
     * @param namePart Partial name to search for
     * @return List of matching reviewers
     * @throws DAOException if query fails
     */
    List<Reviewer> searchByName(String namePart) throws DAOException;

    /**
     * Changes reviewer's password hash.
     * @param reviewerId Reviewer ID
     * @param newPasswordHash New password hash
     * @return true if changed successfully
     * @throws DAOException if update fails
     */
    boolean changePassword(Long reviewerId, String newPasswordHash) throws DAOException;
}