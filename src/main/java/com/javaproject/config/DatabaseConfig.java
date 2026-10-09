package com.javaproject.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Database configuration loaded from JSON config file.
 * Contains all settings needed to connect to MySQL database.
 *
 * <p>Big Brother reads this from {@code config/database.json} via ConfigLoader.
 * No driver behaviour, locations, or scoring parameters live here — only
 * connection settings.</p>
 */
public class DatabaseConfig {

    // TODO 1: `@JsonProperty("host") private String host = "localhost";`
    //   - MySQL hostname. validate() must reject null/blank.
    //   - Jackson maps JSON key "host" to this field automatically.

    // TODO 2: `@JsonProperty("port") private int port = 3306;`
    //   - MySQL port. validate() must enforce 1..65535.
    //   - Wrong port is the #1 "connection refused" cause — fail fast here.

    // TODO 3: `@JsonProperty("database") private String database = "bigbrother";`
    //   - Schema name. validate() rejects null/blank.
    //   - Must exist: CREATE DATABASE bigbrother; before first connect.

    // TODO 4: `@JsonProperty("username") private String username = "root";`
    //   - DB user. validate() rejects null/blank. Never commit real passwords.

    // TODO 5: `@JsonProperty("password") private String password = "";`
    //   - DB password (empty for local dev). Load from file only — never hardcode
    //     production credentials. Consider env-var override in future.

    // TODO 6: `@JsonProperty("useSSL") private boolean useSSL = true;`
    //   - Passed into JDBC URL as useSSL=true/false. Local dev often needs false;
    //     production must be true.

    // TODO 7: `@JsonProperty("serverTimezone") private String serverTimezone = "UTC";`
    //   - Prevents MySQL timezone errors. Keep UTC; convert for display in UI.

    // TODO 8: `@JsonProperty("allowPublicKeyRetrieval") private boolean allowPublicKeyRetrieval = true;`
    //   - Required for MySQL 8 caching_sha2_password over non-SSL local connections.

    // TODO 9: `@JsonProperty("connectionTimeout") private int connectionTimeout = 30000;`
    //   - Milliseconds for connect timeout (30s). Passed as Properties/connectTimeout.

    // TODO 10: `@JsonProperty("maxPoolSize") private int maxPoolSize = 10;`
    //   - Reserved for future HikariCP pool. Currently unused (single-connection
    //     mode in DatabaseConnection) but keep in JSON so migration needs no file change.

    // TODO 11: Default constructor (required by Jackson) + all-fields constructor.
    //   - Jackson needs the no-arg constructor; the all-fields one is for tests
    //     and createDefaultConfig().

    // TODO 12: Getters and setters for every field above.

    /**
     * Builds JDBC URL from configuration.
     * TODO-IMPL:
     *   1. Call validate() first — never build a URL from invalid config.
     *   2. Return String.format(
     *        "jdbc:mysql://%s:%d/%s?useSSL=%b&serverTimezone=%s&allowPublicKeyRetrieval=%b",
     *        host, port, database, useSSL, serverTimezone, allowPublicKeyRetrieval);
     *   3. Do NOT append username/password to the URL — they go in Properties
     *      in DatabaseConnection.getConnection().
     * @return JDBC connection URL
     */
    public String buildJdbcUrl() {
        // TODO: implement as described above.
        return null; // Remove after implementation
    }

    /**
     * Validates configuration has required fields.
     * TODO-IMPL, in order:
     *   1. host null/blank    -> throw IllegalArgumentException("host is required").
     *   2. database null/blank-> throw IllegalArgumentException("database is required").
     *   3. username null/blank-> throw IllegalArgumentException("username is required").
     *   4. port <= 0 || > 65535 -> throw IllegalArgumentException("port must be 1-65535").
     *   5. serverTimezone null/blank -> default to "UTC" (or throw — pick and document).
     * @throws IllegalArgumentException if required fields missing
     */
    public void validate() {
        // TODO: implement checks above.
    }
}
