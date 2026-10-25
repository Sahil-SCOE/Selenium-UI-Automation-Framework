# Selenium UI Automation Framework

A Java-based UI automation testing project using Selenium WebDriver, TestNG, and Maven. It demonstrates login testing, reusable page objects, and validation of application behavior.

## Prerequisites

Install the following before running the project:

- **Java JDK 17 or compatible version** — verify with `java -version`.
- **Apache Maven 3.9+** — verify with `mvn -version`.
- **Google Chrome** — required for browser tests.
- **Git** — optional, for cloning the repository.

## Clone the Repository

```bash
git clone https://github.com/Sahil-SCOE/Selenium-UI-Automation-Framework.git
cd Selenium-UI-Automation-Framework
```

## Install Dependencies and Run Tests

```bash
mvn clean test
```

Maven downloads the dependencies declared in `pom.xml`, compiles the project, and executes the configured TestNG suite.

If Maven is not available globally, install Maven or use your IDE's Maven integration.

## Test Scenarios

- Valid credentials: verify successful login and inventory page access.
- Invalid password: verify the expected login error.
- Empty credentials: verify required-field validation.

## Project Structure

```text
src/
  test/
    java/com/portfolio/qa/
      base/
      driver/
      pages/
      tests/
    resources/
      testng.xml
pom.xml
README.md
.gitignore
.github/workflows/ci.yml
```

## Test Reports

After execution, check the `target/surefire-reports/` directory for the generated test reports.

## Technologies

Java, Selenium WebDriver, TestNG, Maven, Git, and GitHub Actions (if CI is configured and working).

## Learning Objectives

- Organize UI tests using the Page Object Model.
- Automate positive and negative login scenarios.
- Use assertions to validate expected outcomes.
- Run and report tests through Maven and TestNG.
