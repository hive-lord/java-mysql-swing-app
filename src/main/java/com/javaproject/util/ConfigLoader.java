package com.javaproject.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaproject.config.DatabaseConfig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Utility for loading application configuration from JSON file.
 * Supports loading from file system or classpath.
 */
public class ConfigLoader {
    // TODO: Add private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class)
    // TODO: Add private static final ObjectMapper objectMapper = new ObjectMapper()
    // TODO: Add private static final String DEFAULT_CONFIG_PATH = "config/database.json"

    /**
     * Loads database configuration from JSON file.
     * First checks file system, then classpath.
     * @return DatabaseConfig instance
     * @throws ConfigException if config cannot be loaded
     */
    public static DatabaseConfig loadDatabaseConfig() throws ConfigException {
        // TODO: Try loading from file system: config/database.json
        // TODO: If file exists, read and parse
        // TODO: Else try loading from classpath: /database.json
        // TODO: If neither found, throw ConfigException
        // TODO: Validate loaded config
        // TODO: Return config
        return null; // Remove after implementation
    }

    /**
     * Loads database configuration from specific file path.
     * @param configPath Path to config file
     * @return DatabaseConfig instance
     * @throws ConfigException if config cannot be loaded
     */
    public static DatabaseConfig loadDatabaseConfig(String configPath) throws ConfigException {
        // TODO: Validate configPath not null/empty
        // TODO: Read file using Files.readString(Path.of(configPath))
        // TODO: Parse JSON using objectMapper.readValue()
        // TODO: Validate config
        // TODO: Return config
        // TODO: Catch IOException and wrap in ConfigException
        return null; // Remove after implementation
    }

    /**
     * Saves database configuration to JSON file.
     * Creates parent directories if they don't exist.
     * @param config Configuration to save
     * @param configPath Path to save config file
     * @throws ConfigException if save fails
     */
    public static void saveDatabaseConfig(DatabaseConfig config, String configPath) throws ConfigException {
        // TODO: Validate config not null
        // TODO: Create parent directories using Files.createDirectories()
        // TODO: Write JSON using objectMapper.writerWithDefaultPrettyPrinter().writeValue()
        // TODO: Catch IOException and wrap in ConfigException
    }

    /**
     * Creates a default configuration file if it doesn't exist.
     * @param configPath Path where config should be created
     * @return Created DatabaseConfig instance
     * @throws ConfigException if creation fails
     */
    public static DatabaseConfig createDefaultConfig(String configPath) throws ConfigException {
        // TODO: Create new DatabaseConfig with defaults
        // TODO: Call saveDatabaseConfig()
        // TODO: Return config
        return null; // Remove after implementation
    }
}

/**
 * Exception for configuration loading errors.
 */
class ConfigException extends Exception {
    // TODO: Add constructor with message and cause
    // TODO: Add constructor with message only
}