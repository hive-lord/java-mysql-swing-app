package com.javaproject.service;

/**
 * Base exception for all Big Brother service layer errors.
 *
 * <p>Service methods validate input, enforce flagging rules, and translate
 * DAOException into this type so the UI only handles one exception family.
 * Validation failures (bad driver ID, negative severity) and rule violations
 * (duplicate driver ID, resolving more events than exist) both surface here.</p>
 */
public class ServiceException extends Exception {

    // TODO 1: Constructor `public ServiceException(String message)`.
    //   For validation failures: e.g. "driver ID is required", "severity must be > 0".

    // TODO 2: Constructor `public ServiceException(String message, Throwable cause)`.
    //   Primary DAO-wrap path: catch (DAOException e) { throw new
    //   ServiceException("could not open flag record for DRV-1042", e); }
    //   Always chain the cause — never swallow it.

    // TODO 3: Constructor `public ServiceException(Throwable cause)`.
    //   Shorthand when message adds nothing beyond the cause.

    // TODO 4 (optional): `private String errorCode;` + getter, e.g.
    //   "DUPLICATE_DRIVER", "DRIVER_NOT_FOUND", "INVALID_SCORE", "STALE_RECORD".
    //   Lets the Swing UI show friendly text while logs keep the full message.
    //   Add constructor ServiceException(String message, String errorCode, Throwable cause).

    // TODO 5: Constructor accepting ServiceException as cause for chaining
    //   (e.g. scorer calls account service internally) — covered by #2, just
    //   document that cause may itself be a ServiceException.
}
