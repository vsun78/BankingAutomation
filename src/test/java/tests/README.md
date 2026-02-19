# ParaBank Selenium Automation Framework

A Page Object Model based automation suite designed to validate the authentication and security boundaries of the ParaBank demo application

## Key Features
* **Page Object Model:** Decoupled UI locators from test logic for high maintainability.
* **Synchronization:** Implemented **Explicit Waits** (`WebDriverWait`) to handle asynchronous rendering and prevent "flaky" tests.
* **BaseTest Architecture:** Centralized browser setup (`@BeforeMethod`) and teardown (`@AfterMethod`) using TestNG annotations.
* **Negative Testing:** Validates security boundaries by ensuring null/invalid credentials are appropriately handled by the application.

## Tech Stack
* **Language:** Java 20
* **Automation:** Selenium WebDriver 4.18.1
* **Test Runner:** TestNG
* **Build Tool:** Maven

## How to Run
1.  **Clone the repo:** `git clone [YOUR_REPO_LINK]`
2.  **Via IDE:** Right-click on `testng.xml` (or the `tests` folder) and select **Run**.
3.  **Via Command Line:** Run `mvn test` from the project root.

## Test Coverage
* `testValidLogin`: Verifies successful redirect to the Account Overview page.
* `testEmptyLoginSecurity`: Ensures the system maintains security boundaries when credentials are not provided.