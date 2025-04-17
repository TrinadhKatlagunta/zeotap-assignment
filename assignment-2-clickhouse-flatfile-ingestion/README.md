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

```
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
```

---

## 🛠 Technologies Used

- React  
- Java Spring Boot  
- ClickHouse JDBC  
- JWT Authentication  
- CSV / Flat File IO

---

## 🧪 How to Run

### 🔧 Backend (Spring Boot)

1. Navigate to the backend/ folder.
2. Open application.properties and configure:
    - ClickHouse connection URL
    - JWT token
3. Build and run using:

```
./mvnw spring-boot:run
```

### 🌐 Frontend (React)
1. Navigate to the frontend/ folder.
2. Install dependencies:

```
npm install
```
3. Start the frontend:

```
npm start
```

---

## 🤖 AI Prompts
All prompts used with AI tools during the assignment are listed in the prompts.txt file in this folder.
