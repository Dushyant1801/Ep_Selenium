## Selenium Automation Test Suite

Overview

This repository contains Selenium test scripts for automating various web application functionalities, such as user registration, form handling, file upload, iframes, login testing, and search functionality.

Directory Structure
```
├── dushyant1801-ep_selenium/
    ├── AddToCartTest.java      # Automates the add-to-cart functionality
    ├── FileUpload.java         # Handles file upload scenarios
    ├── Registration.java       # Automates the user registration process
    ├── formHandle.java         # Handles different form elements and submissions
    ├── iframe.java             # Automates interactions with iframes
    ├── saucsDemoLogin.java     # Automates login functionality
    ├── search.java             # Tests the search functionality
```
Prerequisites

Before running the test scripts, ensure you have the following installed:

Java (JDK 8 or higher)

Selenium WebDriver

ChromeDriver (or appropriate driver for your browser)

Maven (if using a Maven project)

Setup Instructions

Clone the repository:

git clone https://github.com/your-username/dushyant1801-ep_selenium.git

Navigate to the project directory:

cd dushyant1801-ep_selenium

Download the appropriate WebDriver and place it in the project directory or add it to your system's PATH.

Running the Tests

You can execute the test scripts using your preferred IDE (e.g., IntelliJ IDEA, Eclipse) or via the command line:

javac -cp ".;lib/*" Registration.java
java -cp ".;lib/*" Registration

If using Maven, run:

mvn test


