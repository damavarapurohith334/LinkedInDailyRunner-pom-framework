# 🚀 Selenium POM Framework for LinkedIn Automation

This project is a **Selenium WebDriver automation framework** built using the **Page Object Model (POM)** design pattern. It automates LinkedIn tasks such as login, updating your profile headline, and performing searches across Jobs, Groups, and People tabs.

---

## 🔧 Technologies Used

- Java 8+
- Selenium WebDriver
- TestNG
- ExtentReports
- Maven (can be added)
- Page Object Model (POM) Design Pattern

---

## ⚙️ Setup Instructions

### 1. 🔨 Prerequisites

- Java JDK 8 or later
- Chrome Browser
- ChromeDriver in system PATH
- Maven (optional, for future use)
- Internet access

### 2. 📥 Download the Project

Unzip the project or clone it from version control.

### 3. 📄 Configure `config.properties`

Path: `src/test/resources/properties/config.properties`

```properties
browser=chrome
implicitWait=30
url=https://www.linkedin.com/uas/login?session_redirect=https%3A%2F%2Fwww.linkedin.com%2Ffeed%2F
username=your_email_here
password=your_password_here
update_message=Your updated headline here

Configure locators.properties
Path: src/test/resources/properties/locators.properties
This file contains XPath locators used across page classes.

▶️ How to Run the Test
Open the project in Eclipse/IntelliJ.

Ensure the properties files are updated with valid credentials.

Run the test class:

tests.UpdateProfileTest
Or right-click the test class and select Run As → TestNG Test.

📊 Reports
After execution, an HTML report will be generated under:


<project-root>/reports/YYYY-MM-DD_HH-mm-ss.html
Open it in a browser to see detailed test logs with status.

✅ Features
LinkedIn login automation

Headline update via profile edit

Automated search and tab navigation (Jobs, Groups, People)

Screenshot-ready test reports with status using ExtentReports

Easily extendable using Page Object Model (POM)

📌 **To-Do / Enhancements**
 Add Maven pom.xml for dependency management

 Add data-driven testing with Excel or JSON

 Parallel execution with TestNG XML

 Screenshot on failure

 Docker/Selenium Grid integration

🤝 Contributing
Feel free to fork the repo and improve the framework with enhancements or bug fixes.

🛡️ Disclaimer
This project is for educational and personal automation use only. Do not run automation scripts that violate LinkedIn's terms of service.

📬 Contact
Maintained by: Rohith Damavarapu
LinkedIn: linkedin.com/in/rohith-damavarapu
