package com.javaproject.dao;

import com.javaproject.model.BaseEntity;

import java.util.List;
import java.util.Optional;

/**
 * Generic Data Access Object interface defining standard CRUD operations.
 * All entity-specific DAOs should extend this interface.
 *
 * @param <T> Entity type extending BaseEntity
 * @param <ID> ID type (typically Long)
 */
public interface GenericDAO<T extends BaseEntity, ID> {
    /**
     * Saves a new entity to the database.
     * @param entity Entity to save (must not have ID set)
     * @return Saved entity with generated ID
     * @throws DAOException if save fails
     */
    T save(T entity) throws DAOException;

    /**
     * Updates an existing entity in the database.
     * @param entity Entity to update (must have valid ID)
     * @return Updated entity
     * @throws DAOException if update fails or entity not found
     */
    T update(T entity) throws DAOException;

    /**
     * Deletes an entity by its ID.
     * @param id ID of entity to delete
     * @return true if entity was deleted, false if not found
     * @throws DAOException if delete fails
     */
    boolean deleteById(ID id) throws DAOException;

    /**
     * Finds an entity by its ID.
     * @param id ID of entity to find
     * @return Optional containing entity if found, empty otherwise
     * @throws DAOException if query fails
     */
    Optional<T> findById(ID id) throws DAOException;

    /**
     * Retrieves all entities of this type.
     * @return List of all entities (empty list if none)
     * @throws DAOException if query fails
     */
    List<T> findAll() throws DAOException;

    /**
     * Checks if an entity exists by ID.
     * @param id ID to check
     * @return true if entity exists, false otherwise
     * @throws DAOException if query fails
     */
    boolean existsById(ID id) throws DAOException;

    /**
     * Returns the total count of entities.
     * @return Count of all entities
     * @throws DAOException if query fails
     */
    long count() throws DAOException;
}