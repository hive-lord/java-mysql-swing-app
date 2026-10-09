# Big Brother

Automated unsafe-driver flagging system. It ingests driving-event data and flags unsafe drivers automatically — reviewers see flags, they cannot browse or look up drivers manually, and the system never stores locations.

- **MySQL** as the backend database
- **Core services** in Java (layered: model, DAO, service)
- **Swing** for the reviewer desktop console

Full documentation: open `index.html` in a browser (no server needed).

Domain note: the skeleton uses generic names — `User` = reviewer account / anonymized driver identity, `Product` = driver flag record (driver ID as SKU, risk score as price, event count as stock). No table has any location column. Consider renaming `Product` to `DriverFlag` in the final submission.

The repository contains only the class/interface definitions with TODO comments indicating where implementation details should be added. It includes:
- Maven `pom.xml`
- Model classes (`User`, `Product`, `BaseEntity`)
- DAO layer with generic and specific DAOs
- Service layer with business logic interfaces and stubs
- Utility classes for DB connection, config loading, password hashing, and price handling
- Exception types for DAO and Service layers

You can clone the repo, fill in the TODO sections, and run the application.
