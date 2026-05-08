# Diary Application Project

## Overview
A simple, aesthetically pleasing Diary application built with Java Swing and MySQL.

## Architecture
- **DTO (Data Transfer Object):** `test.DiaryEntry.java` - Holds diary data.
- **DAO (Data Access Object):** `test.DiaryDAO.java` - Handles MySQL database interactions.
- **UI (User Interface):** `test.DiaryUI.java` - Swing-based graphical interface.
- **Main:** `Main.java` - Application entry point.

## Conventions
- **Cohesion:** Keep UI logic separate from database logic.
- **Aesthetics:** Use a soft color palette and include image support where applicable.
- **Database:** MySQL. Ensure `mysql-connector-java` is available in the classpath.

## Database Schema
```sql
CREATE DATABASE diary_db;
USE diary_db;
CREATE TABLE diary_entries (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## How to Run
1. **Database Setup:** Run the SQL commands in the "Database Schema" section.
2. **Library:** Add `mysql-connector-j-x.x.x.jar` to your project dependencies.
3. **Database Credentials:** Update `USER` and `PASSWORD` in `test.DiaryDAO.java`.
4. **Images:** Place a file named `diary_icon.png` in the project root to see it in the UI.
5. **Compile & Run:** Run `Main.java`.
