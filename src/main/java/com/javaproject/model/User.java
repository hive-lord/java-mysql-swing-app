package com.javaproject.model;

/**
 * User entity representing a user in the system.
 * Maps to the 'users' table in MySQL database.
 * TODO: Add @Table(name = "users") annotation if using JPA
 */
public class User extends BaseEntity {
    // TODO: Add private String username field (unique, not null)
    // TODO: Add private String email field (unique, not null)
    // TODO: Add private String passwordHash field (not null)
    // TODO: Add private String firstName field
    // TODO: Add private String lastName field
    // TODO: Add private String phoneNumber field
    // TODO: Add private boolean active field (default true)
    // TODO: Add private UserRole role field (enum: ADMIN, USER, MANAGER)
    // TODO: Add private LocalDateTime lastLoginAt field
    // TODO: Generate constructor with required fields (username, email, passwordHash)
    // TODO: Generate getters and setters for all fields
    // TODO: Add helper method getFullName() returning firstName + " " + lastName
    // TODO: Override toString() excluding passwordHash for security
}

/**
 * Enum representing user roles in the system.
 */
enum UserRole {
    ADMIN,
    USER,
    MANAGER
}