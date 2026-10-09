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
 * Utility for loading Big Brother's database config from JSON.
 * Supports loading from file system or classpath.
 *
 * <p>Lookup order in loadDatabaseConfig(): {@code config/database.json} on disk
 * first, then {@code /database.json} on the classpath, else ConfigException.
 * Every loaded config is validated before return.</p>
 */
public class ConfigLoader {

    // TODO 1: `private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class);`
    //   Log path used + success at INFO; failures at ERROR (without printing password).

    // TODO 2: `private static final ObjectMapper objectMapper = new ObjectMapper();`
    //   Single shared mapper (thread-safe after configuration). Do NOT create per call.

    // TODO 3: `private static final String DEFAULT_CONFIG_PATH = "config/database.json";`
    //   Relative to working directory. createDefaultConfig() writes here on first run.

    /**
     * Loads database configuration from the default location.
     * TODO-IMPL:
     *   1. File f = new File(DEFAULT_CONFIG_PATH); if (f.exists())
     *        return loadDatabaseConfig(DEFAULT_CONFIG_PATH);
     *   2. Else try classpath: InputStream in =
     *        ConfigLoader.class.getResourceAsStream("/database.json");
     *      if (in != null) try (in) {
     *        DatabaseConfig c = objectMapper.readValue(in, DatabaseConfig.class);
     *        c.validate(); return c; }
     *   3. Else throw new ConfigException("No config found at " + DEFAULT_CONFIG_PATH
     *      + " or classpath /database.json. Run createDefaultConfig().");
     * @return DatabaseConfig instance
     * @throws ConfigException if config cannot be loaded
     */
    public static DatabaseConfig loadDatabaseConfig() throws ConfigException {
        // TODO: implement steps above.
        return null; // Remove after implementation
    }

    /**
     * Loads database configuration from a specific file path.
     * TODO-IMPL:
     *   1. if (configPath == null || configPath.isBlank())
     *        throw new ConfigException("configPath is required");
     *   2. try { String json = Files.readString(Path.of(configPath));
     *        DatabaseConfig c = objectMapper.readValue(json, DatabaseConfig.class);
     *        c.validate(); logger.info("loaded config from {}", configPath); return c; }
     *      catch (IOException e) { throw new ConfigException(
     *        "Failed to load config from " + configPath, e); }
     * @param configPath Path to config file
     * @return DatabaseConfig instance
     * @throws ConfigException if config cannot be loaded
     */
    public static DatabaseConfig loadDatabaseConfig(String configPath) throws ConfigException {
        // TODO: implement steps above.
        return null; // Remove after implementation
    }

    /**
     * Saves database configuration to JSON file.
     * TODO-IMPL:
     *   1. if (config == null) throw new ConfigException("config is required");
     *      config.validate();  // never persist invalid config
     *   2. Path p = Paths.get(configPath); if (p.getParent() != null)
     *        Files.createDirectories(p.getParent());
     *   3. try { objectMapper.writerWithDefaultPrettyPrinter().writeValue(p.toFile(), config); }
     *      catch (IOException e) { throw new ConfigException("Failed to save " + configPath, e); }
     *   4. Log at INFO without password value.
     * @param config Configuration to save
     * @param configPath Path to save config file
     * @throws ConfigException if save fails
     */
    public static void saveDatabaseConfig(DatabaseConfig config, String configPath) throws ConfigException {
        // TODO: implement steps above.
    }

    /**
     * Creates a default configuration file if it doesn't exist.
     * TODO-IMPL:
     *   1. DatabaseConfig c = new DatabaseConfig(); // defaults: localhost:3306
     *   2. saveDatabaseConfig(c, configPath);
     *   3. logger.info("created default config at {}", configPath); return c;
     *   4. If file already exists: load and return it instead of overwriting.
     * @param configPath Path where config should be created
     * @return Created DatabaseConfig instance
     * @throws ConfigException if creation fails
     */
    public static DatabaseConfig createDefaultConfig(String configPath) throws ConfigException {
        // TODO: implement steps above.
        return null; // Remove after implementation
    }
}

/**
 * Exception for configuration loading errors.
 * TODO-IMPL:
 *   1. `public ConfigException(String message)` { super(message); }
 *   2. `public ConfigException(String message, Throwable cause)` { super(message, cause); }
 *   3. Keep package-private (no public modifier) unless UI needs to catch it —
 *      then make public. Never include the DB password in the message.
 */
class ConfigException extends Exception {
    // TODO: add the two constructors above.
}
