# Bookstore API Automation Framework

## 🔍 Overview

This framework automates testing of the FastAPI-based Bookstore API using **RestAssured** and **TestNG** in Java.

## 🚀 Setup Instructions

1. **Start FastAPI Server**
   Run the FastAPI application locally:

   ```bash
   uvicorn main:app --reload
   ```

2. **Run Tests**
   Execute the test suite using Maven:

   ```bash
   mvn clean test
   ```

3. **Generate Allure Report**
   To view the detailed test report:

   ```bash
   mvn allure:serve
   ```

## 🧪 Test Coverage

* `POST /books/` – Create a new book ✅
* `GET /books/` – Retrieve list of books ✅
* `PUT /books/{id}` – Update a book ✅
* `DELETE /books/{id}` – Delete a book ✅

## 🧠 Testing Strategy

* Covers positive and negative test scenarios for robustness
* Uses RestAssured for flexible and readable HTTP request/response handling
* Leverages TestNG for test orchestration, grouping, and parallel execution
* Configuration managed via `ConfigManager` class for environment flexibility

## 🧰 CI/CD

* Integrated GitHub Actions pipeline to trigger tests on every push
* Uses Java 11 and Maven in CI environment
* Plans for enhancing with automatic report deployment to GitHub Pages

## 📂 Sample Report

Allure reports are generated in the `allure-results/` directory. Run `mvn allure:serve` to view them locally.

## 👤 Author

* GitHub: [your-github-username](https://github.com/your-github-username)

---

If you want, I can help you add badges (build status, coverage) or extend the README with more details (e.g., environment variables, troubleshooting). Just ask!
