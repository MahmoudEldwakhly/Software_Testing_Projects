# AutomationExercise E2E Test Suite

[![Java](https://img.shields.io/badge/Java-17-red)](https://www.java.com/)
[![Selenium](https://img.shields.io/badge/Selenium-4-green)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-Testing-orange)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-Build-blue)](https://maven.apache.org/)
[![Page Object Model](https://img.shields.io/badge/Pattern-POM-blueviolet)](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)

A comprehensive end-to-end test automation suite for [AutomationExercise.com](https://automationexercise.com/), implementing 26 detailed test cases covering functional, UI, and workflow scenarios.

## Table of Contents

- [Overview](#-overview)
- [Tech Stack](#-tech-stack)
- [Skills Demonstrated](#-skills-demonstrated)
- [Project Structure](#-project-structure)
- [Framework Design](#-framework-design)
- [Test Cases](#-test-cases)
- [Installation & Setup](#-installation--setup)


## Overview

This project automates the complete user journey on AutomationExercise.com, implementing 26 comprehensive test cases that cover:

- ✅ User registration and authentication flows
- ✅ Product search and navigation
- ✅ Shopping cart management
- ✅ Order processing and checkout
- ✅ Form submissions and newsletter subscriptions
- ✅ Category and brand navigation
- ✅ Scroll behaviors and UI interactions
- ✅ Address validation and invoice downloads

## Tech Stack

- **Language**: Java 17
- **Build Tool**: Maven
- **Testing Framework**: TestNG with Surefire
- **UI Automation**: Selenium 4 (Chrome)
- **Design Pattern**: Page Object Model (POM)
- **Reporting**: TestNG/Surefire Reports (target/surefire-reports)

## Skills Demonstrated

- **End-to-end test design** for UI flows and edge cases
- **Selenium automation** with explicit waits, JS fallback clicks, scrolling, resilient locators
- **TestNG suite management**, assertions, parameterization
- **POM structuring** for reuse and maintainability
- **Debugging** of flaky timing, overlays, modals, dynamic grids
- **Data handling** for registration/login and cleanup workflows


## Framework Design

### SeleniumFrameWork.java
Centralized WebDriver lifecycle management with robust interaction methods:

**Lifecycle Management**:
- `initializeBrowser()`, `closeBrowser()`
- `implicitWait(int)`, `navigateToURL(String)`

**Smart Waits**:
- `explicitWait(By, int)` - Explicit waits with configurable timeouts

**Resilient Interactions**:
- `click(By)` - Auto-wait before clicking
- `clickWithJS(By)` - JavaScript click for overlay/intercept scenarios
- `sendKeys(By, String)` - Safe text input
- `getText(By)` - Text extraction
- `clearAndSendKeys(By, String)` - Prevents quantity concatenation ("41")
- `scrollToElement(By)` - Ensures element visibility

**Dropdown Handling**:
- `selectByValue(By, String)`
- `selectByVisibleText(By, String)`

### Page Objects Architecture

**HomePage**:
- Home visibility checks
- Navigation (Products, Cart, Signup-Login, Delete Account)
- Hero text validation
- Footer "SUBSCRIPTION" and "RECOMMENDED ITEMS"
- Arrow-up control handling

**ProductsPage**:
- All Products verification
- Search functionality (input/button/header/results)
- Category & brand sidebars navigation
- View Product details
- Add-to-Cart operations (grid/search/indexed)
- Continue Shopping and View Cart actions

**ProductDetailPage**:
- Product information validation
- Quantity selection
- Add to Cart functionality
- Review form ("Write Your Review") with success banner

**CartPage**:
- Row presence verification
- Price/quantity/total cell validation
- Per-line total calculations
- Delete (X) functionality
- Empty-cart banner handling
- Row counting methods

**CheckoutPage**:
- Proceed to Checkout flows
- Register/Login entry points
- Delivery & billing address blocks
- Review order process
- Comment input
- Place Order functionality
- Download Invoice capability
- Continue actions

**LoginPage/SignupPage/RegistrationPage**:
- Login functionality
- Signup processes
- Account info completion (title, password, DOB, newsletter/offers, full address)
- "ACCOUNT CREATED!" / "ACCOUNT DELETED!" banner handling
- Continue navigation

**PaymentPage**:
- Cardholder input fields
- Pay & Confirm actions
- Success message verification after order completion

## 🧪 Test Cases Details

### TC01 — Register User
**Goal**: New account creation flow
**Data**: Generated email, password, full address
**Pages**: Home → Signup/Login → Signup → Registration → Registration success
**Assertions**: "ACCOUNT CREATED!", "Logged in as …"
**Notes**: Uses selectByValue/VisibleText for DOB, robust waits for banners

### TC02 — Login User (valid)
**Goal**: Login with correct credentials
**Data**: Existing email/password
**Pages**: Home → Signup/Login → Login block
**Assertions**: "Logged in as …"
**Notes**: Explicit wait on user icon

### TC03 — Login User (invalid)
**Goal**: Login error validation
**Data**: Invalid email/password
**Pages**: Home → Signup/Login
**Assertions**: Invalid credentials error visible
**Notes**: Robust xpath targeting error text

### TC04 — Logout User
**Goal**: Logout path verification
**Data**: Valid account
**Pages**: Home → Signup/Login → Logout
**Assertions**: Login form visible again
**Notes**: Session clearance verification

### TC05 — Register with existing email
**Goal**: Duplicate signup handling
**Data**: Existing email
**Pages**: Signup/Login → Signup
**Assertions**: "Email Address already exist!"
**Notes**: Case-insensitive email checking

### TC06 — Contact Us Form
**Goal**: Form submission flow
**Data**: Name, email, subject, message
**Pages**: Contact form page
**Assertions**: Success banner verification
**Notes**: Alert handling with switch-to

### TC07 — Verify Test Cases Page
**Goal**: Test cases listing page access
**Data**: N/A
**Pages**: Home → Test Cases
**Assertions**: Test cases title section visible
**Notes**: Scroll handling for header overlaps

### TC08 — Verify All Products & Details
**Goal**: Products grid and detail information
**Data**: N/A
**Pages**: Products → Product detail
**Assertions**: Name/category/price/availability/condition/brand visibility
**Notes**: clickWithJS for overlay bypassing

### TC09 — Search Product
**Goal**: Search functionality validation
**Data**: Query such as "dress"
**Pages**: Products
**Assertions**: "SEARCHED PRODUCTS" header and matching tiles
**Notes**: Resilient header text matching

### TC10 — Verify Subscription (home)
**Goal**: Footer subscription success
**Data**: Email for subscription
**Pages**: Home footer
**Assertions**: "You have been successfully subscribed!"
**Notes**: Uppercase contains check for title

### TC11 — Verify Subscription (cart)
**Goal**: Subscription from cart page
**Data**: Email
**Pages**: Cart footer
**Assertions**: Success banner visibility
**Notes**: Footer lazy-loading with scroll first

### TC12 — Add Products in Cart
**Goal**: Multiple item addition with validation
**Data**: N/A
**Pages**: Products → cart modal → Cart
**Assertions**: Row presence, price/qty/total mathematical correctness
**Notes**: CartPage helpers for total validation

### TC13 — Verify Product quantity in Cart
**Goal**: Quantity setting and verification
**Data**: Quantity = 4
**Pages**: Product detail → Cart
**Assertions**: Quantity button text equals "4"
**Notes**: clearAndSendKeys prevents "41" concatenation

### TC14 — Place Order: Register while Checkout
**Goal**: Registration during checkout process
**Data**: Generated email; address; payment data
**Pages**: Cart → Checkout → Register/Login → Signup → Registration → Checkout → Payment
**Assertions**: Order success message
**Notes**: Modal View Cart usage; Pay button JS click

### TC15 — Place Order: Register before Checkout
**Goal**: Pre-registration then ordering
**Data**: Generated email; address; payment
**Pages**: Signup/Login → Registration → Products → Cart → Checkout → Payment
**Assertions**: Success message; account deletion
**Notes**: "Logged in as …" header verification

### TC16 — Place Order: Login before Checkout
**Goal**: Login first, then order completion
**Data**: Existing email/password; payment
**Pages**: Signup/Login → Products → Cart → Checkout → Payment
**Assertions**: Success message; account cleanup
**Notes**: Session stability maintenance

### TC17 — Remove Products From Cart
**Goal**: Cart item deletion
**Data**: Pre-added items
**Pages**: Cart
**Assertions**: "Cart is empty" banner or row count decrease
**Notes**: Wait for row removal/empty text

### TC18 — View Category Products
**Goal**: Category navigation validation
**Data**: Subcategory names (e.g., "Dress", "Tshirts")
**Pages**: Products side bar
**Assertions**: Category-specific header verification
**Notes**: Scroll to sidebar before toggles

### TC19 — View & Cart Brand Products
**Goal**: Brand filtering functionality
**Data**: Brand names (e.g., "POLO")
**Pages**: Products brand box
**Assertions**: Header contains BRAND - NAME PRODUCTS
**Notes**: Case-insensitive matching; scroll to brand box

### TC20 — Search Products and Verify Cart After Login
**Goal**: Cart persistence across sessions
**Data**: Query (e.g., "dress"); email/password
**Pages**: Products (search) → Cart → Signup/Login → Home → Cart
**Assertions**: Cart rows match pre-login count
**Notes**: Mixed add strategy + fallback; row counting

### TC21 — Add review on product
**Goal**: Review submission validation
**Data**: Name, email, review text
**Pages**: Product detail → Reviews section
**Assertions**: "Thank you for your review." success
**Notes**: JS click for submit interception

### TC22 — Add to cart from Recommended items
**Goal**: Recommended section interaction
**Data**: N/A
**Pages**: Home footer
**Assertions**: Selected product in cart
**Notes**: Scroll required before panel rendering

### TC23 — Verify address details in checkout page
**Goal**: Address validation in checkout
**Data**: Full registration address
**Pages**: Signup/Login → Registration → Products → Cart → Checkout
**Assertions**: Delivery/billing block field matching
**Notes**: String contains with case/spacing normalization

### TC24 — Download Invoice after purchase order
**Goal**: Invoice download verification
**Data**: Generated email; payment data
**Pages**: Cart → Checkout → Payment → Order success → Download Invoice → Continue
**Assertions**: Success message; download acknowledgement
**Notes**: UI state verification (no filesystem checks)

### TC25 — Verify Scroll Up using 'Arrow' button and Scroll Down
**Goal**: Arrow scroll functionality
**Data**: N/A
**Pages**: Home
**Assertions**: Subscription visibility; hero text after scroll
**Notes**: scrollToElement() + arrow click

### TC26 — Verify Scroll Up without 'Arrow' button and Scroll Down
**Goal**: Programmatic scroll validation
**Data**: N/A
**Pages**: Home
**Assertions**: Subscription visibility; hero text after scroll
**Notes**: JS window.scrollTo(0,0) implementation

## Installation & Setup

### Prerequisites
- Java JDK 17 or higher
- Maven 3.6+
- Chrome browser

### Video Link of 26 testcases Running : https://youtu.be/B5VAwy0bBdo?si=KxX-ngIiy0kWOZ42

### Installation Steps

1. **Clone the repository**:
```bash
git clone <repository-url>
cd automationexercise-e2e-suite


