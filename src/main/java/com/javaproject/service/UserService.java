package com.javaproject.service;

import com.javaproject.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for User business logic.
 * Contains validation, business rules, and orchestrates DAO operations.
 */
public interface UserService {
    /**
     * Registers a new user.
     * Validates input, hashes password, saves to database.
     * @param username Unique username
     * @param email Unique email
     * @param password Plain text password (will be hashed)
     * @param firstName User's first name
     * @param lastName User's last name
     * @return Created user
     * @throws ServiceException if validation fails or user already exists
     */
    User registerUser(String username, String email, String password, String firstName, String lastName) throws ServiceException;

    /**
     * Authenticates a user with username and password.
     * @param username Username or email
     * @param password Plain text password
     * @return Optional containing authenticated user if credentials valid
     * @throws ServiceException if authentication error
     */
    Optional<User> authenticate(String username, String password) throws ServiceException;

    /**
     * Updates user profile information.
     * @param userId User ID
     * @param firstName New first name (nullable)
     * @param lastName New last name (nullable)
     * @param phoneNumber New phone number (nullable)
     * @param email New email (nullable, must be unique)
     * @return Updated user
     * @throws ServiceException if validation fails or user not found
     */
    User updateProfile(Long userId, String firstName, String lastName, String phoneNumber, String email) throws ServiceException;

    /**
     * Changes user's password.
     * @param userId User ID
     * @param currentPassword Current plain text password
     * @param newPassword New plain text password
     * @return true if changed successfully
     * @throws ServiceException if validation fails or current password incorrect
     */
    boolean changePassword(Long userId, String currentPassword, String newPassword) throws ServiceException;

    /**
     * Finds a user by ID.
     * @param userId User ID
     * @return Optional containing user if found
     * @throws ServiceException if query fails
     */
    Optional<User> findById(Long userId) throws ServiceException;

    /**
     * Finds a user by username.
     * @param username Username
     * @return Optional containing user if found
     * @throws ServiceException if query fails
     */
    Optional<User> findByUsername(String username) throws ServiceException;

    /**
     * Gets all active users.
     * @return List of active users
     * @throws ServiceException if query fails
     */
    List<User> getActiveUsers() throws ServiceException;

    /**
     * Gets all users with a specific role.
     * @param role User role
     * @return List of users with role
     * @throws ServiceException if query fails
     */
    List<User> getUsersByRole(User.UserRole role) throws ServiceException;

    /**
     * Searches users by name.
     * @param namePart Partial name
     * @return List of matching users
     * @throws ServiceException if query fails
     */
    List<User> searchUsers(String namePart) throws ServiceException;

    /**
     * Deactivates a user (soft delete).
     * @param userId User ID
     * @return true if deactivated
     * @throws ServiceException if user not found
     */
    boolean deactivateUser(Long userId) throws ServiceException;

    /**
     * Activates a user.
     * @param userId User ID
     * @return true if activated
     * @throws ServiceException if user not found
     */
    boolean activateUser(Long userId) throws ServiceException;

    /**
     * Changes user's role (admin only).
     * @param userId User ID
     * @param newRole New role
     * @return Updated user
     * @throws ServiceException if user not found or invalid role
     */
    User changeUserRole(Long userId, User.UserRole newRole) throws ServiceException;
}