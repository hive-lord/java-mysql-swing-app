package com.javaproject.service;

import com.javaproject.dao.UserDAO;
import com.javaproject.model.User;
import com.javaproject.util.PasswordUtil;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Reviewer-account business logic for Big Brother.
 * Contains validation, password hashing, and DAO orchestration.
 *
 * <p>Rules enforced here (not in UI or DAO): username/email format, password
 * strength, uniqueness, active-check on login, last-login stamping. All
 * DAOException are translated to ServiceException.</p>
 */
public class UserServiceImpl implements UserService {

    // TODO 0a: `private static final Logger logger = ...UserServiceImpl.class);`
    // TODO 0b: `private final UserDAO userDAO;` + `private final PasswordUtil passwordUtil;`
    // TODO 0c: Patterns + constant:
    //   EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    //   USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{3,20}$");
    //   MIN_PASSWORD_LENGTH = 8;
    // TODO 0d: `public UserServiceImpl(UserDAO userDAO, PasswordUtil passwordUtil)` —
    //   requireNonNull both. Constructor injection keeps this testable with fake DAOs.

    @Override
    public User registerUser(String username, String email, String password, String firstName, String lastName) throws ServiceException {
        // TODO 1: validateUsername(username): non-null, trim, matches USERNAME_PATTERN —
        //   else ServiceException("username must be 3-20 letters/digits/underscore").
        // TODO 2: validateEmail(email): non-null, matches EMAIL_PATTERN, store lowercase —
        //   else ServiceException("invalid email").
        // TODO 3: validatePassword(password): non-null, length >= 8 —
        //   else ServiceException("password must be at least 8 characters").
        //   (Future: also require a digit; keep simple for coursework.)
        // TODO 4: validateName(firstName/lastName): non-blank each.
        // TODO 5: try { if (userDAO.existsByUsername(username)) throw new
        //   ServiceException("username already taken"); } catch (DAOException e) { wrap }
        //   Same for existsByEmail. (Race still possible — DB UNIQUE is final guard;
        //   catch its DAOException and rethrow as "already exists".)
        // TODO 6: String hash = passwordUtil.hashPassword(password); // NEVER store plain.
        // TODO 7: User u = new User(username.trim(), email.trim().toLowerCase(), hash);
        //   u.setFirstName/LastName(trimmed); u.setRole(User.UserRole.USER);
        //   u.setActive(true);
        // TODO 8: try { User saved = userDAO.save(u);
        //   logger.info("registered reviewer {}", username); return saved; }
        //   catch (DAOException e) { throw new ServiceException("registration failed", e); }
        return null; // Remove after implementation
    }

    @Override
    public Optional<User> authenticate(String username, String password) throws ServiceException {
        // TODO 1: if either null/blank throw ServiceException("username and password required").
        //   (Throw, don't return empty — caller bug vs bad credentials must differ.)
        // TODO 2: try {
        //   Optional<User> u = userDAO.findByUsername(username.trim());
        //   if (u.isEmpty()) u = userDAO.findByEmail(username.trim().toLowerCase());
        // TODO 3: if (u.isEmpty() || !u.get().isActive()) return Optional.empty();
        //   (Same response for unknown vs inactive — do not leak which.)
        // TODO 4: if (!passwordUtil.verifyPassword(password, u.get().getPasswordHash()))
        //   return Optional.empty();
        // TODO 5: userDAO.updateLastLogin(id, LocalDateTime.now());
        //   If stamping fails, still return the user (login succeeded) but log warn.
        // TODO 6: logger.info("login {}", username); return u;
        //   } catch (DAOException e) { throw new ServiceException("authentication error", e); }
        return Optional.empty(); // Remove after implementation
    }

    @Override
    public User updateProfile(Long userId, String firstName, String lastName, String phoneNumber, String email) throws ServiceException {
        // TODO 1: if (userId == null) throw ServiceException("user id required").
        // TODO 2: Load: User u = userDAO.findById(userId).orElseThrow(() ->
        //   new ServiceException("reviewer not found"));
        // TODO 3: If email != null: validate format; check existsByEmail AND the owner
        //   isn't this user (load by email, compare ids) — else "email already in use".
        //   Then u.setEmail(lowercased).
        // TODO 4: For each of firstName/lastName/phoneNumber: if non-null, validate
        //   (names non-blank; phone 10-15 chars loose check) and set.
        // TODO 5: userDAO.update(u); log; return updated. Wrap DAOException.
        return null; // Remove after implementation
    }

    @Override
    public boolean changePassword(Long userId, String currentPassword, String newPassword) throws ServiceException {
        // TODO 1: Null/blank-check all three; newPassword length >= 8.
        // TODO 2: Load user or throw "reviewer not found".
        // TODO 3: if (!passwordUtil.verifyPassword(currentPassword, u.getPasswordHash()))
        //   throw new ServiceException("current password is incorrect");
        // TODO 4: String hash = passwordUtil.hashPassword(newPassword);
        //   userDAO.changePassword(userId, hash); log (id only); return true.
        // TODO 5: Wrap DAOException as ServiceException("password change failed", e).
        return false; // Remove after implementation
    }

    @Override
    public Optional<User> findById(Long userId) throws ServiceException {
        // TODO 1: Validate non-null. try { return userDAO.findById(userId); }
        //   catch (DAOException e) { throw new ServiceException("lookup failed", e); }
        return Optional.empty(); // Remove after implementation
    }

    @Override
    public Optional<User> findByUsername(String username) throws ServiceException {
        // TODO 1: Validate non-blank; delegate to userDAO.findByUsername; wrap exception.
        return Optional.empty(); // Remove after implementation
    }

    @Override
    public List<User> getActiveUsers() throws ServiceException {
        // TODO 1: try { return userDAO.findActiveUsers(); } catch wrap.
        //   Admin screen + login eligibility source.
        return List.of(); // Remove after implementation
    }

    @Override
    public List<User> getUsersByRole(User.UserRole role) throws ServiceException {
        // TODO 1: if (role == null) throw ServiceException("role is required").
        // TODO 2: Delegate to userDAO.findByRole(role); wrap. (Needs UserRole fix first.)
        return List.of(); // Remove after implementation
    }

    @Override
    public List<User> searchUsers(String namePart) throws ServiceException {
        // TODO 1: if null/blank throw ServiceException. Delegate to userDAO.searchByName.
        //   Admin account search only.
        return List.of(); // Remove after implementation
    }

    @Override
    public boolean deactivateUser(Long userId) throws ServiceException {
        // TODO 1: Validate, load or throw "not found". u.setActive(false);
        //   userDAO.update(u); logger.info("deactivated {}", userId); return true.
        //   Inactive reviewers immediately fail authenticate().
        return false; // Remove after implementation
    }

    @Override
    public boolean activateUser(Long userId) throws ServiceException {
        // TODO 1: Mirror deactivate with setActive(true).
        return false; // Remove after implementation
    }

    @Override
    public User changeUserRole(Long userId, User.UserRole newRole) throws ServiceException {
        // TODO 1: Validate both non-null. Load or throw "not found".
        // TODO 2: u.setRole(newRole); userDAO.update(u);
        //   logger.info("role {} -> {} for {}", old, new, userId); return u.
        // TODO 3: Caller (UI) must restrict this to ADMIN callers — enforce here
        //   if caller identity is passed in future (service-level authz).
        return null; // Remove after implementation
    }

    // TODO: `private void validateUsername(String v)` — null/blank + pattern check.
    // TODO: `private void validateEmail(String v)` — null/blank + pattern check.
    // TODO: `private void validatePassword(String v)` — null + length >= 8.
    // TODO: `private void validateName(String v, String field)` — null/blank check
    //   with field name in message. All throw ServiceException (not DAOException).
}
