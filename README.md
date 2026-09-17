# Selenium Java Automation Testing

Automated end-to-end (E2E) testing project using **Selenium WebDriver** and **JUnit 5** with **Maven** in Java.

The test suite validates the authentication flow on the [SeleniumBase Simple Login Demo](https://seleniumbase.io/simple/login).

---

## 🛠 Tech Stack

- **Language:** Java 21
- **Build Tool:** Apache Maven
- **Automation Framework:** Selenium WebDriver (`selenium-java` 4.35.0)
- **Test Framework:** JUnit 5 Jupiter (`junit-jupiter` 5.11.4)
- **Browser:** Google Chrome (managed via Selenium Manager / ChromeDriver)

---

## 📁 Project Structure

```text
selenium_java/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/example/App.java
    └── test/
        └── java/
            └── com/example/
                ├── AppTest.java
                └── LoginTest.java
```

---

## 🧪 Test Scenarios (`LoginTest.java`)

All tests run against `https://seleniumbase.io/simple/login`:

| Test Method | Description | Expected Result |
|-------------|-------------|-----------------|
| `shouldLoginSuccessfully` | Submits valid username (`demo_user`) and password (`secret_pass`). | Redirects and shows heading `Welcome!` |
| `shouldFailLoginWithInvalidCredentials` | Submits invalid username (`invalid_user`) and password (`wrong_pass`). | Shows error `Invalid Username!` |
| `shouldFailLoginWithEmptyCredentials` | Clicks sign-in without filling username and password. | Shows error `The Username is Required!` |
| `shouldFailLoginWithEmptyPassword` | Submits username only (`demo_user`) with empty password. | Shows error `The Password is Required!` |
| `shouldFailLoginWithEmptyUsername` | Submits password only (`secret_pass`) with empty username. | Shows error `The Username is Required!` |

---

## 📋 Prerequisites

- **Java JDK 21+**: Verify by running `java -version`
- **Apache Maven**: Verify by running `mvn -version`
- **Google Chrome**: Installed on the machine

---

## 🚀 Running the Tests

From this directory:

### 1. Run all tests
```bash
mvn test
```

### 2. Run only `LoginTest`
```bash
mvn test -Dtest=LoginTest
```

### 3. Run a specific test scenario
```bash
mvn test -Dtest=LoginTest#shouldLoginSuccessfully
```

### 4. Clean build and run
```bash
mvn clean test
```

---

## 💡 Notes & Best Practices

- **ChromeDriver**: Selenium 4 automatically handles driver binaries using Selenium Manager (no manual `chromedriver` download required).
- **Element Locators**:
  - Username: `By.id("username")`
  - Password: `By.id("password")`
  - Sign in button: `By.id("log-in")`
  - Error messages: `By.id("top_message")`
  - Success welcome header: `By.tagName("h1")`
