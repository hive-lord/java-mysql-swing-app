package com.javaproject.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Base entity class with common fields for all database entities.
 *
 * <p>In Big Brother every record (reviewer account in {@code users},
 * driver flag record in {@code products}) shares these four audit columns.
 * There is intentionally NO location field anywhere in this hierarchy.</p>
 */
public abstract class BaseEntity {

    // TODO 1: Add field `private Long id;`
    //   - Primary key, auto-increment in MySQL (BIGINT AUTO_INCREMENT).
    //   - Null before first save; set from ResultSet.getGeneratedKeys() after INSERT.
    //   - Never set manually except in tests.
    //   - Example: this.id = rs.getLong("id");

    // TODO 2: Add field `private LocalDateTime createdAt;`
    //   - Set once on save. Use LocalDateTime.now() if DB does not return it.
    //   - Maps to `created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP`.
    //   - Never updated afterwards.

    // TODO 3: Add field `private LocalDateTime updatedAt;`
    //   - Touch on every update (save + update + flag changes).
    //   - Maps to `updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP`.
    //   - In DAO update methods: ps.setTimestamp(..., Timestamp.valueOf(LocalDateTime.now())).

    // TODO 4: Add field `private Integer version = 0;`
    //   - Optimistic locking counter. Starts at 0, +1 on each successful update.
    //   - Every UPDATE must include `WHERE id = ? AND version = ?`.
    //   - If rows-affected == 0 -> someone else modified the row: throw DAOException("concurrent modification").
    //   - Why it matters for Big Brother: two events for the same driver arriving
    //     concurrently must not silently overwrite each other's score/count.

    // TODO 5: Generate getters and setters for all four fields.
    //   - Standard JavaBean style. Setter for createdAt is used by the
    //     mapResultSet helpers; setter for version increments after update.

    // TODO 6: Override equals() and hashCode() based ONLY on id.
    //   - Two entities are equal iff both ids are non-null and equal.
    //   - Use Objects.equals(id, other.id) / Objects.hash(id).
    //   - Do NOT include mutable fields (score, count) — they change on every event.
    //   - Sketch:
    //     if (this == o) return true;
    //     if (!(o instanceof BaseEntity)) return false;
    //     BaseEntity that = (BaseEntity) o;
    //     return id != null && Objects.equals(id, that.id);

    // TODO 7: Override toString() for debugging.
    //   - Include id, createdAt, updatedAt, version only.
    //   - Subclasses append their own fields. Never print password hashes here.
}
