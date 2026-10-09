package com.javaproject.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Driver flag record in Big Brother. Maps to the {@code driver_flags} table.
 *
 * <p>One row per anonymized driver. The automatic scorer updates this row on
 * every driving event; when count/score crosses the threshold the row appears
 * in the reviewer flag queue. There are NO location columns — by design.</p>
 *
 * <p>Fields:</p>
 * <ul>
 *   <li>driverId = anonymized driver ID (e.g. DRV-1042), UNIQUE</li>
 *   <li>riskScore = risk score, BigDecimal scale 2 (e.g. 7.75, threshold 7.00)</li>
 *   <li>eventCount = pending event count</li>
 *   <li>flagThreshold = flag threshold count</li>
 *   <li>eventType = event class (speeding / harsh-braking / signal-jump)</li>
 * </ul>
 *
 * <p>TODO: Add {@code @Table(name = "driver_flags")} annotation if using JPA.</p>
 */
public class DriverFlag extends BaseEntity {

    // TODO 1: `private String label;` — NOT NULL. Display label for the driver
    //   record (e.g. anonymized short ID or case reference). Shown in flag queue.
    //   Max ~100 chars, non-blank. Column: label VARCHAR(100) NOT NULL.

    // TODO 2: `private String summary;` — nullable TEXT.
    //   Event summary written by the scorer (e.g. "3x harsh-braking, 1x speeding").
    //   Never a location. Nullable in mapping — preserve null from ResultSet.

    // TODO 3: `private String driverId;` — UNIQUE, NOT NULL. The anonymized driver ID.
    //   Format convention: DRV-#### (e.g. DRV-1042). Enforced in service:
    //   non-blank, uppercase, uniqueness via existsByDriverId() before save.
    //   DAO lookup case-insensitive: WHERE LOWER(driver_id) = LOWER(?).
    //   Column: driver_id VARCHAR(50) UNIQUE NOT NULL, indexed.

    // TODO 4: `private BigDecimal riskScore;` — NOT NULL, DECIMAL(10,2). The risk score.
    //   Range 0.00-10.00, always rounded via RiskScoreUtil.round() (SCALE=2, HALF_EVEN).
    //   Each event adds severity weight; resolution subtracts. Compare against
    //   threshold in service to decide flagged vs clear.

    // TODO 5: `private Integer eventCount = 0;` — NOT NULL, DEFAULT 0.
    //   Pending event count for this driver. +1 per ingested event (recordEvent(+1)),
    //   -1 per resolved event (recordEvent(-1)). Guard: never below 0 —
    //   DAO must read current value first and reject negative results.

    // TODO 6: `private Integer flagThreshold = 10;` — DEFAULT 10. The flag threshold count.
    //   Flag rule: flagged when eventCount >= flagThreshold OR riskScore >= scoreThreshold.
    //   Tunable per driver class; service validates >= 0.

    // TODO 7: `private String eventType;` — event/vehicle class.
    //   E.g. "speeding", "harsh-braking", "signal-jump", or vehicle class.
    //   Indexed; used by findByEventType() to filter the queue. Non-blank on create.

    // TODO 8: `private boolean active = true;` — flag-record open (true) vs closed (false).
    //   closeFlag() sets false + closedAt instead of DELETE (soft-close,
    //   keeps audit history). findActiveFlags() filters active=true.

    // TODO 9: `private LocalDateTime closedAt;` — nullable.
    //   Timestamp when the flag was cleared/closed. Set in closeFlag(),
    //   cleared in reopenFlag(). Null = currently open.

    // TODO 10: Constructor `public DriverFlag(String label, String driverId, BigDecimal riskScore)`.
    //   Sets required fields, rounds riskScore via RiskScoreUtil, defaults eventCount=0,
    //   flagThreshold=10, active=true. Validate non-null/non-blank; throw
    //   IllegalArgumentException on bad input.

    // TODO 11: Getters and setters for all fields.

    // TODO 12: Helper `public boolean isFlagged()`.
    //   In Big Brother semantics this means IS-FLAGGED:
    //   return eventCount != null && flagThreshold != null
    //       && eventCount >= flagThreshold;
    //   (Template comment says <=; for flagging, >= is the trigger — pick one
    //   and document it. Queue query mirrors this in SQL.)

    // TODO 13: Helper `public boolean isReviewable()`.
    //   Means record is reviewable: return active && eventCount != null
    //   && eventCount > 0. Used to filter empty/closed rows from the queue.

    // TODO 14: Override toString() with id, driverId, label, riskScore, eventCount, eventType,
    //   active — safe (no secrets in this entity).
}
