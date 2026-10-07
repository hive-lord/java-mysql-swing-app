package com.javaproject.dao;

import com.javaproject.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for User entity.
 * Defines user-specific database operations beyond generic CRUD.
 */
public interface UserDAO extends GenericDAO<User, Long> {
    /**
     * Finds a user by username (case-insensitive).
     * @param username Username to search for
     * @return Optional containing user if found
     * @throws DAOException if query fails
     */
    Optional<User> findByUsername(String username) throws DAOException;

    /**
     * Finds a user by email (case-insensitive).
     * @param email Email to search for
     * @return Optional containing user if found
     * @throws DAOException if query fails
     */
    Optional<User> findByEmail(String email) throws DAOException;

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
     * Finds all users with a specific role.
     * @param role User role to filter by
     * @return List of users with the given role
     * @throws DAOException if query fails
     */
    List<User> findByRole(User.UserRole role) throws DAOException;

    /**
     * Finds all active users.
     * @return List of active users
     * @throws DAOException if query fails
     */
    List<User> findActiveUsers() throws DAOException;

    /**
     * Updates user's last login timestamp.
     * @param userId User ID
     * @param loginTime Login timestamp
     * @return true if updated successfully
     * @throws DAOException if update fails
     */
    boolean updateLastLogin(Long userId, java.time.LocalDateTime loginTime) throws DAOException;

    /**
     * Searches users by partial name match (first or last name).
     * @param namePart Partial name to search for
     * @return List of matching users
     * @throws DAOException if query fails
     */
    List<User> searchByName(String namePart) throws DAOException;

    /**
     * Changes user's password hash.
     * @param userId User ID
     * @param newPasswordHash New password hash
     * @return true if changed successfully
     * @throws DAOException if update fails
     */
    boolean changePassword(Long userId, String newPasswordHash) throws DAOException;
}