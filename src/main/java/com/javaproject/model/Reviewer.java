package com.javaproject.model;

import java.time.LocalDateTime;

/**
 * Reviewer account in Big Brother. Maps to the {@code reviewers} table.
 *
 * <p>NOT a driver-tracking record: this is the login account for the humans
 * who review automatically-raised flags (admin / senior reviewer / reviewer).
 * Driver identities themselves live in the flag-record table (DriverFlag).</p>
 *
 * <p>TODO: Add {@code @Table(name = "reviewers")} annotation if using JPA.</p>
 */
public class Reviewer extends BaseEntity {

    public enum ReviewerRole {
        ADMIN,
        REVIEWER,
        MANAGER
    }

    // TODO 1: `private String username;` — UNIQUE, NOT NULL, 3-20 chars.
    //   - Allowed: letters, digits, underscore. Regex enforced in service:
    //     ^[a-zA-Z0-9_]{3,20}$
    //   - DAO lookup is case-insensitive: WHERE LOWER(username) = LOWER(?).
    //   - Trim before save; reject null/blank with ServiceException.

    // TODO 2: `private String email;` — UNIQUE, NOT NULL.
    //   - Validate with EMAIL_PATTERN ^[A-Za-z0-9+_.-]+@(.+)$ in ReviewerServiceImpl.
    //   - Store lowercase. Uniqueness checked via existsByEmail() before save.
    //   - Used as alternate login identifier in authenticate().

    // TODO 3: `private String passwordHash;` — NOT NULL, BCrypt string (~60 chars).
    //   - NEVER store plain text. Service hashes via PasswordUtil.hashPassword()
    //     with LOG_ROUNDS=12 before calling DAO.
    //   - Column: password_hash VARCHAR(255) NOT NULL.
    //   - toString() MUST exclude this field (security).

    // TODO 4: `private String firstName;` + TODO 5: `private String lastName;`
    //   - Reviewer display name. Both required at registration (non-blank).
    //   - Max ~50 chars each. Shown in flag-queue "reviewed by" column.

    // TODO 6: `private String phoneNumber;` — nullable, 10-15 chars.
    //   - Optional contact for escalation. Validate loosely (digits, +, spaces).
    //   - Nullable in ResultSet mapping: rs.getString() may return null — keep null.

    // TODO 7: `private boolean active = true;`
    //   - Soft-disable. deactivateReviewer() sets false instead of DELETE.
    //   - authenticate() must reject inactive accounts (return Optional.empty()).

    // TODO 8: `private ReviewerRole role;` — enum ADMIN / MANAGER / REVIEWER.
    //   - ADMIN = system admin, MANAGER = senior reviewer (can change roles),
    //     REVIEWER = reviewer (confirm/clear flags only).
    //   - Column: role VARCHAR(20) NOT NULL DEFAULT 'REVIEWER'.

    // TODO 9: `private LocalDateTime lastLoginAt;` — nullable.
    //   - Stamped by updateLastLogin() on every successful authenticate().
    //   - SQL: UPDATE reviewers SET last_login_at = ?, updated_at = ? WHERE id = ?.

    // TODO 10: Constructor `public Reviewer(String username, String email, String passwordHash)`.
    //   - Sets the three required fields; service sets role=REVIEWER, active=true.
    //   - Validate non-null inside constructor; throw IllegalArgumentException.

    // TODO 11: Getters and setters for all fields above.

    // TODO 12: Helper `public String getFullName()` returning firstName + " " + lastName.
    //   - Null-safe: skip null parts, trim result.

    // TODO 13: Override toString() with id, username, email, names, role, active —
    //   explicitly WITHOUT passwordHash.
}
