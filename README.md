# Selenium Advanced Framework - UI Automation

![Java](https://img.shields.io/badge/Java-11%2B-007396?logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-IDE-000000?logo=intellijidea&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36?logo=apachemaven&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-Web%20Automation-43B02A?logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-Framework-FF6C37?logo=testng&logoColor=white)
![AssertJ](https://img.shields.io/badge/AssertJ-Assertions-6DB33F)
![Allure](https://img.shields.io/badge/Allure-Reports-FF69B4?logo=qameta&logoColor=white)
![Log4j2](https://img.shields.io/badge/Log4j2-Logging-CC0000?logo=apache&logoColor=white)
![Apache POI](https://img.shields.io/badge/Apache%20POI-Excel%20DataDriven-2496ED?logo=apache&logoColor=white)

---

## 🗂️ Overview  

This repository contains a **Selenium Advanced Automation Framework** built using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**.

It demonstrates a **hybrid test automation architecture**, combining **Page Object Model (POM)** and **Page Factory**, **Data-Driven Testing (Apache POI)**, **TestNG Listeners**, **Log4j Logging**, and **Retry logic** — creating a robust, maintainable, and reusable automation framework.

---

## ⚙️ Tech Stack

- **Java 11+**
- **IntelliJ IDEA** – IDE for development
- **Maven** – Build & dependency management
- **Selenium WebDriver** – Browser automation
- **TestNG** – Testing framework
- **Log4j2** – Centralized logging and debugging
- **Apache POI** – Excel-based data handling
- **Allure Reports** – Reporting framework

---

## 🚀 Features

- **Hybrid Page Object Model** with both PageFactory and traditional POM implementations
- **Reusable components** for driver management, utilities, and base setup
- **DriverManager** for efficient WebDriver lifecycle control
- **Excel-based Data-Driven Testing** using Apache POI
- **Centralized Logging** using **Log4j**
- **Retry and Screenshot Listeners** integrated with TestNG for robust failure handling
- Organized **TestNG suite XMLs** for modular and parallel test execution
- **Allure Reporting** integration for clean, visual, and detailed reports

---

## 🧩 Framework Highlights

### 🧱 Base Classes

- **`CommonToAllPage.java`** – Base class for all page objects (shared web actions & utilities)
- **`CommonToAllTest.java`** – Base class for all test cases (setup, teardown, and configuration)

##

### 🧪 Utilities

- **`DriverManager.java`** – Centralized WebDriver lifecycle and thread-safe driver management
- **`PropertiesReader.java`** – Loads configuration values from properties files
- **`UtilExcel.java`** – Excel-driven data utility powered by Apache POI
- **`WaitHelpers.java`** – Utility for explicit, fluent, and conditional waits

##

### 🔁 Listeners

- **`RetryAnalyzer.java`** – Automatically retries failed tests
- **`RetryListeners.java`** – Integrates retry logic into TestNG
- **`ScreenshotListeners.java`** – Captures and stores screenshots on test failures

## 

### 📚 Modules Overview

| Module / Category   | Description                                   |
| :------------------ | :-------------------------------------------- |
| **appVWO**          | Test cases related to app.vwo.com             |
| **katalonCURA**     | Automation for Katalon CURA Healthcare        |
| **orangeHRM**       | Tests for OrangeHRM login scenarios           |
| **pageFactory**     | PageFactory-based framework examples          |
| **pageObjectModel** | Standard Page Object Model implementation     |
| **listeners**       | Retry and screenshot functionality demos      |
| **dataDrivenTests** | Excel-based login automation using Apache POI |

---

## 🏗️ Project Structure

```bash
Selenium_Advance_Framework/
│
├── .idea/                                                                                      # IntelliJ project files
├── .mvn/                                                                                       # Maven wrapper files
├── allure-results/                                                                             # Allure report results
├── failure_screenshots/                                                                        # Screenshots from failed tests
├── logs/									
│   └── test.log                                                                                # Test execution logs
│									
├── src/									
│   ├── main/									
│   │   ├── java/com.avinashsinha/									
│   │   │   ├── base/									
│   │   │   │   └── CommonToAllPage.java                                                        # Base class for all Pages
│   │   │   │
│   │   │   ├── driver/
│   │   │   │   └── DriverManager.java                                                          # WebDriver manager
│   │   │   │
│   │   │   ├── pages/
│   │   │   │   ├── pageFactory/
│   │   │   │   │   ├── appVWO/
│   │   │   │   │   │   ├── DashboardPage_PF.java
│   │   │   │   │   │   └── LoginPage_PF.java
│   │   │   │   │   │
│   │   │   │   │   ├── katalonCURA/
│   │   │   │   │   │   ├── BookingPage_PF.java
│   │   │   │   │   │   ├── LoginPage_PF.java
│   │   │   │   │   │   ├── MakeAppointmentPage_PF.java
│   │   │   │   │   │   └── SummaryPage_PF.java
│   │   │   │   │   │
│   │   │   │   │   └── orangeHRM/
│   │   │   │   │       ├── EmployeeListHomePage_PF.java
│   │   │   │   │       └── LoginPage_PF.java
│   │   │   │   │
│   │   │   │   └── pageObjectModel/
│   │   │   │       ├── appVWO/
│   │   │   │       │   ├── improved_POM/
│   │   │   │       │   │   ├── DashboardPage.java
│   │   │   │       │   │   └── LoginPage.java
│   │   │   │       │   │
│   │   │   │       │   └── normal_POM/
│   │   │   │       │       ├── DashboardPage.java
│   │   │   │       │       └── LoginPage.java
│   │   │   │       │
│   │   │   │       ├── katalonCURA/
│   │   │   │       │   ├── BookingPage.java
│   │   │   │       │   ├── LoginPage.java
│   │   │   │       │   ├── MakeAppointmentPage.java
│   │   │   │       │   └── SummaryPage.java
│   │   │   │       │
│   │   │   │       └── orangeHRM/
│   │   │   │           ├── EmployeeListHomePage.java
│   │   │   │           └── LoginPage.java
│   │   │   │
│   │   │   └── utils/
│   │   │       ├── PropertiesReader.java                                                       # Property reader utility
│   │   │       ├── UtilExcel.java                                                              # Excel helper
│   │   │       └── WaitHelpers.java                                                            # Explicit wait helpers
│   │   │									
│   │   └── resources/									
│   │       ├── data.properties                                                                 # Environment & test config
│   │       ├── log4j2.xml                                                                      # Logging configuration
│   │       └── TestData.xlsx                                                                   # Excel test dataset
│   │									
│   └── test/									
│       └── java/com.avinashsinha/									
│           ├── base/									
│           │   └── CommonToAllTest.java                                                        # Base class for all tests
│           │
│           ├── listeners/
│           │   ├── RetryAnalyzer.java                                                          # Retry logic
│           │   ├── RetryListeners.java                                                         # Retry listener
│           │   └── ScreenshotListeners.java                                                    # Capture screenshot on failure
│           │
│           └── tests/
│               ├── pageFactory/
│               │   ├── appVWO/
│               │   │   └── TestAppVWLoginPage_PF.java
│               │   │
│               │   ├── katalonCURA/
│               │   │   └── TestKatalonCURALoginPage_PF.java
│               │   │
│               │   └── orangeHRM/
│               │       └── TestOrangeHRMLoginPage_PF.java
│               │
│               └── pom/
│                   ├── appVWO/
│                   │   ├── DDT/
│                   │   │   └── TestAppVWLoginPage_DDT.java
│                   │   ├── TestAppVWLoginPage_01_NormalScript_POM.java
│                   │   ├── TestAppVWLoginPage_02_PropertyReader_DriverManager_POM.java
│                   │   ├── TestAppVWLoginPage_03_PropertyReader_DriverManager_POM.java
│                   │   ├── TestAppVWLoginPage_04_PropertyReader_DriverManager_POM.java
│                   │   ├── TestAppVWLoginPage_RetryListeners.java
│                   │   └── TestAppVWLoginPage_RetryListeners_ScreenshotListeners.java
│                   │
│                   ├── katalonCURA/
│                   │   └── TestKatalonCURALoginPage_01.java
│                   │
│                   └── orangeHRM/
│                       └── TestOrangeHRMLoginPage_01.java
│
├── testNG-xmls/                                                                                # Organized TestNG suite XMLs
│   ├── testng_appVWLoginPage_01.xml
│   ├── testng_appVWLoginPage_02.xml
│   ├── testng_appVWLoginPage_03.xml
│   ├── testng_appVWLoginPage_04.xml
│   ├── testng_appVWLoginPage_DDT.xml
│   ├── testng_appVWLoginPage_PF.xml
│   ├── testng_appVWLoginPage_RetryListeners.xml
│   ├── testng_appVWLoginPage_RetryListenersScreenshotListeners.xml
│   ├── testng_KatalonCURALoginPage_01.xml
│   ├── testng_KatalonCURALoginPage_PF.xml
│   ├── testng_OrangeHRMLoginPage_01.xml
│   └── testng_OrangeHRMLoginPage_PF.xml
│   
│
├── pom.xml                                                                                     # Maven configuration
├── .gitignore
│
└── README.md

```
---

## ▶️ Running Tests

### Run a Specific TestNG Suite

```bash
mvn clean test -DsuiteXmlFile=testng_appVWOLoginPage_01.xml
```

#### Commonly Used TestNG Suites

| TestNG File                                 | Purpose                          |
| :------------------------------------------ | :------------------------------- |
| `testng_appVWOLoginPage_PF.xml`             | PageFactory-based tests          |
| `testng_appVWOLoginPage_DDT.xml`            | Data-driven login tests          |
| `testng_appVWOLoginPage_RetryListeners.xml` | Retry + Listener-based execution |
| `testng_KatalonCURALoginPage_PF.xml`        | Katalon CURA login tests         |
| `testng_OrangeHRMLoginPage_PF.xml`          | OrangeHRM login tests            |

---

## 📊 Reporting

### Generate Allure Report

```bash
allure serve allure-results
```

This opens a **beautiful interactive report** in your browser, showing execution summary, test logs, and screenshots for failed tests.

Example Allure dashboard view:

<img width="1920" height="1114" alt="a" src="https://github.com/user-attachments/assets/1d4e888d-7939-4264-b60d-720acab27ec9" />

---

## 📌 Author
👤 Avinash Sinha

---

🧠 This framework is built for **advanced Selenium automation learning and practice**, focusing on **real-world framework design**, **scalability**, **reusability**, and **maintainability** — powered by **Selenium**, **TestNG**, and **Maven**.


---
