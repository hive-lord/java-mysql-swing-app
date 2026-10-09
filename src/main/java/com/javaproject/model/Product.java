package com.javaproject.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Driver flag record in Big Brother. Maps to the {@code products} table.
 *
 * <p>One row per anonymized driver. The automatic scorer updates this row on
 * every driving event; when count/score crosses the threshold the row appears
 * in the reviewer flag queue. There are NO location columns — by design.</p>
 *
 * <p>Name mapping (skeleton keeps generic names):</p>
 * <ul>
 *   <li>sku = anonymized driver ID (e.g. DRV-1042), UNIQUE</li>
 *   <li>price = risk score, BigDecimal scale 2 (e.g. 7.75, threshold 7.00)</li>
 *   <li>quantityInStock = pending event count</li>
 *   <li>reorderLevel = flag threshold count</li>
 *   <li>category = event class (speeding / harsh-braking / signal-jump)</li>
 * </ul>
 *
 * <p>TODO: Add {@code @Table(name = "products")} annotation if using JPA.
 * Final submission should rename this class to DriverFlag.</p>
 */
public class Product extends BaseEntity {

    // TODO 1: `private String name;` — NOT NULL. Display label for the driver
    //   record (e.g. anonymized short ID or case reference). Shown in flag queue.
    //   Max ~100 chars, non-blank. Column: name VARCHAR(100) NOT NULL.

    // TODO 2: `private String description;` — nullable TEXT.
    //   Event summary written by the scorer (e.g. "3x harsh-braking, 1x speeding").
    //   Never a location. Nullable in mapping — preserve null from ResultSet.

    // TODO 3: `private String sku;` — UNIQUE, NOT NULL. The anonymized driver ID.
    //   Format convention: DRV-#### (e.g. DRV-1042). Enforced in service:
    //   non-blank, uppercase, uniqueness via existsBySku() before save.
    //   DAO lookup case-insensitive: WHERE LOWER(sku) = LOWER(?).
    //   Column: sku VARCHAR(50) UNIQUE NOT NULL, indexed.

    // TODO 4: `private BigDecimal price;` — NOT NULL, DECIMAL(10,2). The risk score.
    //   Range 0.00-10.00, always rounded via PriceUtil.round() (SCALE=2, HALF_EVEN).
    //   Each event adds severity weight; resolution subtracts. Compare against
    //   threshold in service to decide flagged vs clear.

    // TODO 5: `private Integer quantityInStock = 0;` — NOT NULL, DEFAULT 0.
    //   Pending event count for this driver. +1 per ingested event (adjustStock(+1)),
    //   -1 per resolved event (adjustStock(-1)). Guard: never below 0 —
    //   DAO must read current value first and reject negative results.

    // TODO 6: `private Integer reorderLevel = 10;` — DEFAULT 10. The flag threshold count.
    //   Flag rule: flagged when quantityInStock >= reorderLevel OR price >= scoreThreshold.
    //   Tunable per driver class; service validates >= 0.

    // TODO 7: `private String category;` — event/vehicle class.
    //   E.g. "speeding", "harsh-braking", "signal-jump", or vehicle class.
    //   Indexed; used by findByCategory() to filter the queue. Non-blank on create.

    // TODO 8: `private boolean active = true;` — flag-record open (true) vs closed (false).
    //   discontinueProduct() sets false + discontinuedAt instead of DELETE (soft-close,
    //   keeps audit history). findActiveProducts() filters active=true.

    // TODO 9: `private LocalDateTime discontinuedAt;` — nullable.
    //   Timestamp when the flag was cleared/closed. Set in discontinueProduct(),
    //   cleared in reactivateProduct(). Null = currently open.

    // TODO 10: Constructor `public Product(String name, String sku, BigDecimal price)`.
    //   Sets required fields, rounds price via PriceUtil, defaults quantity=0,
    //   reorderLevel=10, active=true. Validate non-null/non-blank; throw
    //   IllegalArgumentException on bad input.

    // TODO 11: Getters and setters for all fields.

    // TODO 12: Helper `public boolean isLowStock()`.
    //   In Big Brother semantics this means IS-FLAGGED:
    //   return quantityInStock != null && reorderLevel != null
    //       && quantityInStock >= reorderLevel;
    //   (Template comment says <=; for flagging, >= is the trigger — pick one
    //   and document it. Queue query mirrors this in SQL.)

    // TODO 13: Helper `public boolean isAvailable()`.
    //   Means record is reviewable: return active && quantityInStock != null
    //   && quantityInStock > 0. Used to filter empty/closed rows from the queue.

    // TODO 14: Override toString() with id, sku, name, price, quantity, category,
    //   active — safe (no secrets in this entity).
}
