package com.javaproject.service;

import com.javaproject.dao.UserDAO;
import com.javaproject.model.User;
import com.javaproject.util.PasswordUtil;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Implementation of UserService.
 * Contains business logic, validation, and password hashing.
 */
public class UserServiceImpl implements UserService {
    // TODO: Add private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class)
    // TODO: Add private final UserDAO userDAO field
    // TODO: Add private final PasswordUtil passwordUtil field
    // TODO: Add private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$")
    // TODO: Add private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{3,20}$")
    // TODO: Add private static final int MIN_PASSWORD_LENGTH = 8
    // TODO: Add constructor accepting UserDAO and PasswordUtil

    @Override
    public User registerUser(String username, String email, String password, String firstName, String lastName) throws ServiceException {
        // TODO: Validate username: not null, matches USERNAME_PATTERN
        // TODO: Validate email: not null, matches EMAIL_PATTERN
        // TODO: Validate password: not null, length >= MIN_PASSWORD_LENGTH
        // TODO: Validate firstName and lastName: not null/empty
        // TODO: Check if username already exists using userDAO.existsByUsername()
        // TODO: Check if email already exists using userDAO.existsByEmail()
        // TODO: Hash password using passwordUtil.hashPassword()
        // TODO: Create new User entity with validated data and hashed password
        // TODO: Set role to USER, active to true
        // TODO: Save using userDAO.save()
        // TODO: Log successful registration
        // TODO: Return created user
        // TODO: Catch DAOException and wrap in ServiceException
        return null; // Remove after implementation
    }

    @Override
    public Optional<User> authenticate(String username, String password) throws ServiceException {
        // TODO: Validate username and password not null/empty
        // TODO: Find user by username (also tries email) using userDAO.findByUsername()
        // TODO: If not found, try findByEmail()
        // TODO: If user found and active, verify password using passwordUtil.verifyPassword()
        // TODO: If password valid, update last login using userDAO.updateLastLogin()
        // TODO: Return Optional.of(user) or Optional.empty()
        // TODO: Catch DAOException and wrap in ServiceException
        return Optional.empty(); // Remove after implementation
    }

    @Override
    public User updateProfile(Long userId, String firstName, String lastName, String phoneNumber, String email) throws ServiceException {
        // TODO: Validate userId not null
        // TODO: Find existing user by ID
        // TODO: If not found, throw ServiceException
        // TODO: If email provided, validate format and check uniqueness (excluding current user)
        // TODO: Update fields if provided (non-null)
        // TODO: Save using userDAO.update()
        // TODO: Log profile update
        // TODO: Return updated user
        // TODO: Catch DAOException and wrap in ServiceException
        return null; // Remove after implementation
    }

    @Override
    public boolean changePassword(Long userId, String currentPassword, String newPassword) throws ServiceException {
        // TODO: Validate userId, currentPassword, newPassword not null/empty
        // TODO: Validate newPassword length >= MIN_PASSWORD_LENGTH
        // TODO: Find user by ID
        // TODO: If not found, throw ServiceException
        // TODO: Verify current password using passwordUtil.verifyPassword()
        // TODO: If invalid, throw ServiceException
        // TODO: Hash new password
        // TODO: Update using userDAO.changePassword()
        // TODO: Log password change
        // TODO: Return true
        // TODO: Catch DAOException and wrap in ServiceException
        return false; // Remove after implementation
    }

    @Override
    public Optional<User> findById(Long userId) throws ServiceException {
        // TODO: Validate userId
        // TODO: Call userDAO.findById()
        // TODO: Catch DAOException and wrap in ServiceException
        return Optional.empty(); // Remove after implementation
    }

    @Override
    public Optional<User> findByUsername(String username) throws ServiceException {
        // TODO: Validate username
        // TODO: Call userDAO.findByUsername()
        // TODO: Catch DAOException and wrap in ServiceException
        return Optional.empty(); // Remove after implementation
    }

    @Override
    public List<User> getActiveUsers() throws ServiceException {
        // TODO: Call userDAO.findActiveUsers()
        // TODO: Catch DAOException and wrap in ServiceException
        return List.of(); // Remove after implementation
    }

    @Override
    public List<User> getUsersByRole(User.UserRole role) throws ServiceException {
        // TODO: Validate role not null
        // TODO: Call userDAO.findByRole()
        // TODO: Catch DAOException and wrap in ServiceException
        return List.of(); // Remove after implementation
    }

    @Override
    public List<User> searchUsers(String namePart) throws ServiceException {
        // TODO: Validate namePart not null/empty
        // TODO: Call userDAO.searchByName()
        // TODO: Catch DAOException and wrap in ServiceException
        return List.of(); // Remove after implementation
    }

    @Override
    public boolean deactivateUser(Long userId) throws ServiceException {
        // TODO: Validate userId
        // TODO: Find user by ID
        // TODO: If not found, throw ServiceException
        // TODO: Set user.active = false
        // TODO: Save using userDAO.update()
        // TODO: Log deactivation
        // TODO: Return true
        // TODO: Catch DAOException and wrap in ServiceException
        return false; // Remove after implementation
    }

    @Override
    public boolean activateUser(Long userId) throws ServiceException {
        // TODO: Validate userId
        // TODO: Find user by ID
        // TODO: If not found, throw ServiceException
        // TODO: Set user.active = true
        // TODO: Save using userDAO.update()
        // TODO: Log activation
        // TODO: Return true
        // TODO: Catch DAOException and wrap in ServiceException
        return false; // Remove after implementation
    }

    @Override
    public User changeUserRole(Long userId, User.UserRole newRole) throws ServiceException {
        // TODO: Validate userId and newRole
        // TODO: Find user by ID
        // TODO: If not found, throw ServiceException
        // TODO: Set user.role = newRole
        // TODO: Save using userDAO.update()
        // TODO: Log role change
        // TODO: Return updated user
        // TODO: Catch DAOException and wrap in ServiceException
        return null; // Remove after implementation
    }

    // TODO: Add private void validateUsername(String username) throws ServiceException helper
    // TODO: Add private void validateEmail(String email) throws ServiceException helper
    // TODO: Add private void validatePassword(String password) throws ServiceException helper
    // TODO: Add private void validateName(String name, String fieldName) throws ServiceException helper
}