package com.javaproject.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Password hashing for Big Brother reviewer logins (BCrypt).
 *
 * <p>PREREQUISITE: add to pom.xml (currently missing — code does not compile
 * without it): {@code org.mindrot:jbcrypt:0.4}. Only reviewer passwords are
 * hashed; driver flag records contain no credentials.</p>
 */
public class PasswordUtil {

    // TODO 1: `private static final int LOG_ROUNDS = 12;`
    //   BCrypt work factor (2^12 rounds). 12 = current recommended default:
    //   ~200ms per hash on typical hardware. Higher = slower logins but stronger.
    //   needsRehash() compares a stored hash's cost against this constant.

    // TODO 2: `public String hashPassword(String plain)` — main entry point.
    //   1. if (plain == null || plain.length() < 8) throw IllegalArgumentException.
    //   2. return BCrypt.hashpw(plain, BCrypt.gensalt(LOG_ROUNDS));
    //   Called by ReviewerServiceImpl.registerReviewer() BEFORE DAO save. Never log `plain`.

    // TODO 3: Overload `public String hashPassword(String plain, int logRounds)`.
    //   Same as above with custom cost. Validate 4 <= logRounds <= 31
    //   (BCrypt limits). Used by tests to use cost 4 for speed.

    // TODO 4: `public boolean verifyPassword(String plain, String hash)`.
    //   1. if either null/empty return false (do not throw — login path).
    //   2. try { return BCrypt.checkpw(plain, hash); }
    //      catch (IllegalArgumentException e) { return false; } // malformed hash
    //   Must be constant-work on failure — BCrypt.checkpw already is.

    // TODO 5: `public boolean needsRehash(String hash)`.
    //   Returns true when stored hash used a different cost than LOG_ROUNDS
    //   (e.g. after raising work factor). Parse: BCrypt hash format
    //   $2a$12$... — extract "12" and compare to LOG_ROUNDS.
    //   If true, service re-hashes on next successful login and updates the row.

    // TODO 6: `public String generateSalt()`.
    //   return BCrypt.gensalt(LOG_ROUNDS); Exposed for tests; production code
    //   should prefer hashPassword() directly.

    // TODO 7: `public String rehashPassword(String plain)`.
    //   Convenience: return hashPassword(plain); Called after needsRehash()==true
    //   post-login. Then persist via ReviewerDAO.changePassword().
}
