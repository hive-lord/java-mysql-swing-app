package com.javaproject.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Database configuration loaded from JSON config file.
 * Contains all settings needed to connect to MySQL database.
 */
public class DatabaseConfig {
    // TODO: Add @JsonProperty("host") private String host = "localhost"
    // TODO: Add @JsonProperty("port") private int port = 3306
    // TODO: Add @JsonProperty("database") private String database = "javaproject"
    // TODO: Add @JsonProperty("username") private String username = "root"
    // TODO: Add @JsonProperty("password") private String password = ""
    // TODO: Add @JsonProperty("useSSL") private boolean useSSL = true
    // TODO: Add @JsonProperty("serverTimezone") private String serverTimezone = "UTC"
    // TODO: Add @JsonProperty("allowPublicKeyRetrieval") private boolean allowPublicKeyRetrieval = true
    // TODO: Add @JsonProperty("connectionTimeout") private int connectionTimeout = 30000
    // TODO: Add @JsonProperty("maxPoolSize") private int maxPoolSize = 10 (for future HikariCP)

    // TODO: Generate default constructor
    // TODO: Generate constructor with all fields
    // TODO: Generate getters and setters for all fields

    /**
     * Builds JDBC URL from configuration.
     * @return JDBC connection URL
     */
    public String buildJdbcUrl() {
        // TODO: Return String.format("jdbc:mysql://%s:%d/%s?useSSL=%b&serverTimezone=%s&allowPublicKeyRetrieval=%b",
        //         host, port, database, useSSL, serverTimezone, allowPublicKeyRetrieval)
        return null; // Remove after implementation
    }

    /**
     * Validates configuration has required fields.
     * @throws IllegalArgumentException if required fields missing
     */
    public void validate() {
        // TODO: Check host not null/empty
        // TODO: Check database not null/empty
        // TODO: Check username not null/empty
        // TODO: Check port > 0 and <= 65535
        // TODO: Throw IllegalArgumentException with descriptive message if validation fails
    }
}