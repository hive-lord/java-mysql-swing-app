# Big Brother

Automated unsafe-driver flagging system. It ingests driving-event data and flags unsafe drivers automatically — reviewers see flags, they cannot browse or look up drivers manually, and the system never stores locations.

- **MySQL** as the backend database (`bigbrother`: `reviewers` + `driver_flags`)
- **Core services** in Java (layered: model, DAO, service)
- **Swing** for the reviewer desktop console (`ui.MainFrame`, planned)

Full documentation: open `index.html` in a browser (no server needed).

Domain model (no generic shop names):
- `Reviewer` = reviewer account (`reviewers` table, roles ADMIN / MANAGER / REVIEWER)
- `DriverFlag` = driver flag record (`driver_flags` table: `driverId`, `riskScore`, `eventCount`, `flagThreshold`, `eventType`)
- `RiskScoreUtil` = exact decimal math for risk scores; `PasswordUtil` = BCrypt for reviewer logins

The repository contains only the class/interface definitions with TODO comments indicating where implementation details should be added. It includes:
- Maven `pom.xml`
- Model classes (`Reviewer`, `DriverFlag`, `BaseEntity`)
- DAO layer (`ReviewerDAO`, `DriverFlagDAO` + impls, `GenericDAO`, `DAOException`)
- Service layer (`ReviewerService`, `DriverFlagService` + impls, `ServiceException`)
- Utility classes for DB connection, config loading, password hashing, and risk-score math
- Exception types for DAO and Service layers

You can clone the repo, fill in the TODO sections, and run the application.
