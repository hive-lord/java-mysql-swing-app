# Traffic Management System

A Java desktop application for traffic operations (officer accounts, vehicle registry, violations and fines) using:
- **MySQL** as the backend database
- **Core services** implemented in Java (layered: model, DAO, service)
- **Swing** for the desktop UI (frontend)

Full documentation: open `index.html` in a browser (no server needed).

Domain note: the skeleton uses generic names — `User` = officer/admin account, `Product` = vehicle / challan record (registration no. as SKU, fine as price). Consider renaming `Product` to `Vehicle` in the final submission.

The repository contains only the class/interface definitions with TODO comments indicating where implementation details should be added. It includes:
- Maven `pom.xml`
- Model classes (`User`, `Product`, `BaseEntity`)
- DAO layer with generic and specific DAOs
- Service layer with business logic interfaces and stubs
- Utility classes for DB connection, config loading, password hashing, and price handling
- Exception types for DAO and Service layers

You can clone the repo, fill in the TODO sections, and run the application.
