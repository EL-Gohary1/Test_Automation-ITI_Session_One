# Test Automation – Selenium + TestNG + Jenkins + Allure

A Java-based UI test automation project built with **Selenium WebDriver**, **TestNG**, **Maven**, and **Allure Reports**, integrated with **Jenkins** for CI/CD pipeline execution.

---

## 📁 Project Structure

```
Test_Automation-ITI_Jenkins/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com.selenium.pages/
│   │           └── WebFormPage.java
│   └── test/
│       └── java/
│           └── com.selenium.tests/
│               ├── DynamicPageTest.java
│               └── WebFormTest.java
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md
```

---

## 🛠️ Tech Stack

* **Language:** Java 19
* **Browser Automation:** Selenium WebDriver 4.39.0
* **Test Framework:** TestNG 7.10.2
* **Build Tool:** Maven
* **Reporting:** Allure 2.24.0
* **CI/CD:** Jenkins
* **Browser Driver:** ChromeDriver (auto-managed)


---

## 🧪 Test Scenarios

### Dynamic Page Tests

**DynamicPageTest.java**

Test Cases:

#### checkButtonAddBox

- Open dynamic page
- Click "Add Box"
- Wait for new element
- Verify background color is red

#### checkRevealNewInput

- Open dynamic page
- Click reveal button
- Wait for input field
- Send text
- Verify input value

---

### Web Form Tests

**WebFormTest.java**

Test Cases:

#### checkFormSubmittedMessage

- Fill form fields
- Select dropdown value
- Select checkbox
- Select radio button
- Submit form
- Verify success message

#### checkDisabledInputIsDisable

- Verify disabled input field

#### checkReadonlyInput

- Verify readonly input field

---

## ⚙️ Prerequisites

Before running the project, make sure you have the following installed:

- **Java JDK 19+** → [Download](https://www.oracle.com/java/technologies/downloads/)
- **Apache Maven** → [Download](https://maven.apache.org/download.cgi)
- **Google Chrome** (latest version)
- **Jenkins** (for CI/CD) → [Download](https://www.jenkins.io/download/)
- **Allure CLI** (for local report generation) → [Install Guide](https://allurereport.org/docs/v2/)

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/EL-Gohary1/Test_Automation-ITI_Jenkins.git
cd Test_Automation-ITI_Jenkins
```

### 2. Run Tests

```bash
mvn clean test
```

This will execute all tests defined in `testng.xml`.

### 3. Generate Allure Report Locally

```bash
allure serve target/allure-results
```

This opens the Allure report in your default browser automatically.

---

## 🔧 TestNG Suite Configuration (`testng.xml`)

The suite runs the following test methods in order:

```
DynamicPageTest  →  checkButtonAddBox, checkRevealNewInput
WebFormTest      →  checkFormSubmittedMessage, checkReadonlyInput
```


---

## 🏗️ Jenkins CI/CD Integration

### Step 1 — Start Jenkins

Download the Jenkins WAR file from the [official website](https://www.jenkins.io/download/), then open CMD and run:

```bash
java -jar jenkins.war
```

Then open your browser and go to:
```
http://localhost:8080
```

---

### Step 2 — Install Allure Plugin

Go to **Manage Jenkins** → **Plugins** → **Available Plugins**, search for and install:

* **Allure Jenkins Plugin**

---

### Step 3 — Configure Tools

Go to **Manage Jenkins** → **Tools** and configure the following:

* **JDK** → Add the path to your Java installation on your machine
   - Example: `C:\Program Files\Java\jdk-19`

* **Maven** → Add the path to your Maven installation on your machine
   - Example: `C:\Program Files\Apache\maven`

* **Allure Commandline** → Add Allure and set the path to your Allure installation
   - Example: `C:\Program Files\allure`

---

### Step 4 — Create a Freestyle Job

1. Click **New Item** → Enter a name → Select **Freestyle Project** → Click OK
2. Under **Build Steps** → Add **Invoke top-level Maven targets**:
   ```
   Goals: clean test
   ```
3. Under **Post-build Actions** → Add **Allure Report**:
   - Set Results Path to: `allure-results`
4. Click **Save** then **Build Now**
