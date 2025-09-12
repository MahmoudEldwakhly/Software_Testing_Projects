# Automation Testing Project

## Project Overview
This project implements automated testing for the [AutomationExercise.com](https://automationexercise.com/) website using Selenium and TestNG. The main goal is to create reliable automated tests that verify key functionalities of the e-commerce website.

## What This Project Does
This testing framework automatically performs user registration on the AutomationExercise website by:
- Opening a web browser and navigating to the website
- Clicking on the signup/login button
- Entering user details like name and email
- Filling out the complete registration form with personal information
- Creating a new user account
- Verifying successful account creation
- Logging in with the new account
- Deleting the test account
- Verifying successful account deletion

## Project Structure
src/
├── main/java/
│ ├── Frameworks/
│ │ ├── SeleniumFrameWork.java # Core selenium functionality
│ │ └── WebDriverManager.java # Browser management
│ └── Main/Pages/
│ ├── HomePage.java # Home page interactions
│ ├── LoginPage.java # Login page interactions
│ ├── SignupPage.java # Signup form interactions
│ └── RegistrationPage.java # Registration success handling
└── test/java/
└── TestCases/
└── RegisterUserTest.java # Main test case

text

## Key Features

### Robust Framework
- **SeleniumFrameWork:** Provides all basic Selenium operations
- **WebDriverManager:** Handles browser setup and management
- **Page Object Model:** Organized structure for easy maintenance

### Reliable Testing
- **Smart Waiting:** Elements wait to be ready before interaction
- **Stable Locators:** Uses data-qa attributes for reliable element finding
- **Error Handling:** Gracefully handles unexpected situations
- **Cross-Browser:** Ready to work with different browsers

### Test Coverage
- **User Registration:** Complete signup process testing
- **Form Validation:** Tests all form fields work correctly
- **Account Management:** Tests both creation and deletion
- **UI Verification:** Confirms all page elements display properly

## How It Works
- **Setup:** The test opens a browser and goes to the website
- **Navigation:** Clicks through the signup process
- **Data Entry:** Fills all required user information
- **Verification:** Checks each step completes successfully
- **Cleanup:** Deletes test accounts after completion
- **Reporting:** Provides clear pass/fail results

## Technologies Used
- Java: Programming language for test automation
- Selenium: Web browser automation tool
- TestNG: Testing framework for organization and reporting
- Maven: Project management and build tool
- Page Object Model: Design pattern for maintainable tests

## Getting Started

### Prerequisites
- Java JDK 11 or higher
- Maven
- Chrome browser

### Running Tests
mvn test

text

### Test Results
- Tests run automatically in Chrome browser
- Results show in console with detailed logs
- Pass/fail status clearly indicated
- Screenshot capability available for debugging

## Benefits
- Time Saving: Automates repetitive manual testing
- Reliable: Consistent test execution every time
- Maintainable: Easy to update when website changes
- Scalable: Can add more test cases easily
- Professional: Industry-standard testing approach

## Future Enhancements
- More test cases for other website features
- Data-driven testing with multiple test datasets
- Cross-browser testing support
- CI/CD integration
- Advanced reporting with screenshots
- Parallel test execution

---

This project demonstrates modern test automation practices using professional tools 