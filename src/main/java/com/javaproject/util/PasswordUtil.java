package com.javaproject.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Utility class for password hashing and verification using BCrypt.
 */
public class PasswordUtil {
    // TODO: Add private static final int LOG_ROUNDS = 12 (work factor)
    // TODO: Add method public String hashPassword(String plain) that returns BCrypt.hashpw(plain, BCrypt.gensalt(LOG_ROUNDS))
    // TODO: Add method public boolean verifyPassword(String plain, String hash) that returns BCrypt.checkpw(plain, hash)
    // TODO: Add method public boolean needsRehash(String hash) that checks if hash's log rounds differ from LOG_ROUNDS
    // TODO: Add method public String generateSalt() that returns BCrypt.gensalt(LOG_ROUNDS)
    // TODO: Add method public String rehashPassword(String plain) that returns hashPassword(plain)
    // TODO: Add overload public String hashPassword(String plain, int logRounds) for custom work factor
}