# Bookstore API Automation Framework

## 🔍 Overview

This framework tests the FastAPI-based Bookstore API using RestAssured and TestNG.

## 🚀 Setup Instructions

1. **Start FastAPI Server**
   ```bash
   uvicorn main:app --reload
   ```

2. **Run Tests**
   ```bash
   mvn clean test
   ```

3. **Generate Allure Report**
   ```bash
   mvn allure:serve
   ```

## 🧪 Test Coverage

- `POST /books/` - Create book ✅
- `GET /books/` - List books ✅
- `PUT /books/{id}` - Update book ✅
- `DELETE /books/{id}` - Delete book ✅

## 🧠 Testing Strategy

- Covered both positive and negative scenarios
- Used RestAssured for flexible request/response handling
- TestNG enables test grouping, parallelism, and hooks
- Configured using `ConfigManager` for environment separation

## 🧰 CI/CD

- GitHub Actions used to trigger tests on every push
- Java 11 environment with Maven
- Future enhancement: Deploy test report to GitHub Pages

## 📂 Sample Report

Allure report generated at: `allure-results/` (run `mvn allure:serve` locally to view)

## 👤 Author

- GitHub: [your-github-username](https://github.com/your-github-username)