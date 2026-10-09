package com.javaproject.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Exact decimal math for Big Brother risk scores (reuses money semantics).
 *
 * <p>Scores are 0.00–10.00, always SCALE=2 HALF_EVEN. Every operation re-rounds
 * so threshold comparisons (>= 7.00 flagged) are deterministic. Double/float
 * must never be used for scores — binary floating point cannot represent
 * 0.1 exactly and would make flag boundaries flaky.</p>
 */
public class PriceUtil {

    // TODO 1: `private static final int SCALE = 2;`
    //   Two decimals (e.g. 7.75). Matches DECIMAL(10,2) column for price/score.

    // TODO 2: `private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;`
    //   Banker's rounding — no systematic upward bias over thousands of events.
    //   Required for fair scoring; do not switch to HALF_UP without documenting why.

    // TODO 3: `public static BigDecimal round(BigDecimal amount)`.
    //   1. if (amount == null) throw IllegalArgumentException("amount is required").
    //   2. return amount.setScale(SCALE, ROUNDING_MODE);
    //   Every method below delegates here — single rounding point.

    // TODO 4: `public static BigDecimal add(BigDecimal a, BigDecimal b)`.
    //   Null-check both, return round(a.add(b)).
    //   Use: score = add(score, severityWeight) per ingested event.

    // TODO 5: `public static BigDecimal subtract(BigDecimal a, BigDecimal b)`.
    //   return round(a.subtract(b)). Use: score reduction on appeal/resolution.
    //   Clamp at ZERO in service (scores never negative).

    // TODO 6: `public static BigDecimal multiply(BigDecimal a, BigDecimal b)`.
    //   return round(a.multiply(b)). Use: weighting (e.g. repeat-offender × 1.5).

    // TODO 7: `public static BigDecimal divide(BigDecimal a, BigDecimal b)`.
    //   1. if (b == null || b.compareTo(BigDecimal.ZERO) == 0)
    //        throw new ArithmeticException("division by zero");
    //   2. return round(a.divide(b, SCALE, ROUNDING_MODE));
    //   Use: averages (total severity / event count). Note divide needs explicit
    //   scale+mode or it throws on non-terminating decimals like 1/3.

    // TODO 8: `public static boolean isPositive(BigDecimal amount)`.
    //   return amount != null && amount.compareTo(BigDecimal.ZERO) > 0;
    //   Use: service validates severityWeight > 0 before adding.
}
