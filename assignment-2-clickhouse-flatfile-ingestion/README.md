# Assignment 2: Bidirectional ClickHouse & Flat File Ingestion Tool

This full-stack application enables bidirectional data ingestion between ClickHouse and Flat Files.

---

## ✅ Features

- 🌐 **Frontend (React):**
  - Source selection: ClickHouse / Flat File
  - Connection inputs: Host, Port, JWT Token
  - Column selection using checkboxes
  - Record count & status display
  - Error messages & loading status

- 🛠 **Backend (Spring Boot):**
  - Handles data transfer between ClickHouse and Flat Files
  - JWT token authentication supported
  - ClickHouse JDBC client
  - CSV file handling and streaming
  - Error handling included

---

## 📂 Folder Structure

```plaintext
assignment-2-clickhouse-flatfile-ingestion/
├── frontend/
│   ├── App.js
│   └── ...
├── backend/
│   ├── src/
│   │   └── main/java/com/example/ingestion/...
│   └── application.properties
├── README.md
└── prompts.txt
