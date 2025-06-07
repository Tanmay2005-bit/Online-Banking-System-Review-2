## Online-Banking-System-Review-2

We have implemented core features, applying techniques to enhance robustness and integration in the Project.  This review assesses technical skills, creativity, and project delivery and we have tried our Best to complete and follow each command very carefully.

Already defined in Review 1 - 
This is a **Console-based Online Banking System** implemented in **Java**.  
The system allows users to:
- ✅ Register and Login
- ✅ Check Balance
- ✅ Deposit Money
- ✅ Withdraw Money
- ✅ View Transaction History

It uses **file-based storage** (`.txt` files) to persist user data and transaction records.  
The application is built using a modular architecture with separate packages for model, service, DAO, and IO operations.

## 📁 Project Structure

Console Banking System

-> Main.java 
Main entry point to launch the app
-> model
User.java # User class containing user attributes
-> dao
 UserDAO.java # Handles user data CRUD operations
->service
BankService.java # Business logic for banking functions
-> io
FileManager.java # File I/O operations (users + transactions)


# users.txt  
Stores registered users
# transactions_<username>.txt  
Individual user transaction history

## Special Feature
This time in review 2 we have added new feature in which the Balance is stored in .txt files along with various transactions details like
Date and Time, making the console based BANKING SYSTEM more effective and more user friendly with new features.

## Requirements - 

Java Development Kit (JDK) 8 or higher installed

Any Java IDE (e.g., NetBeans, IntelliJ IDEA, Eclipse) or command line setup

Basic command line or terminal for running the program

Here in our project we have installed JDK 23 and have used NetBeans as our IDE

## Setup Instructions

-> Clone or download the project source code to your local machine.

-> Open the project in NetBeans:

-> Launch NetBeans IDE.
Go to File > Open Project.
Navigate to the ConsoleBankingSystem folder and select it.
NetBeans will automatically recognize the project and load it.
Build and run the project:

Right-click on the project in the Projects panel.
Select Clean and Build to compile the project.
Select Run to execute the application.

No command-line compilation is needed. All development and execution were handled directly within NetBeans.

## EXECUTION AND LAUNCHING THE APPLICATION

===== Online Banking System =====
1. Register
2. Login
3. Exit
Choose: 1
Enter username: tanmay
Enter password: 1234
Registration successful!

===== Online Banking System =====
1. Register
2. Login
3. Exit
Choose: 2
Username: tanmay
Password: 1234
Login successful.

--- Welcome, tanmay ---
1. Check Balance
2. Deposit
3. Withdraw
4. View Transactions
5. Logout
Choose: 1
Balance: $0.0

Choose: 2
Amount to deposit: 500
Deposit successful.

Choose: 1
Balance: $500.0

Choose: 3
Amount to withdraw: 200
Withdrawal successful.

Choose: 4
--- Transaction History ---
Deposit,500.0,2025-06-07 18:45:12
Withdraw,200.0,2025-06-07 18:46:01

Choose: 5
Logging out...

===== Online Banking System =====
1. Register
2. Login
3. Exit
Choose: 3
Goodbye!

THIS WAY THE EXECUTION OF THIS CONSOLE BASED BANKING SYSTEM WILL BE HELD WITH USERS :-
REGISTRING THEMSELVES FIRST AND THEN USING VARIOUS SERVICES PROVIDED.

## IMPORTANT POINT TO BE TAKEN REGARDING VIEWING OF THE PROJECT

-> Just like review 1, in review 2 also all the updated files and codes are submitted in zip folder.
-> Project is submitted as .zip file in the repository.
-> Codes and .txt file is also seperately included in the repository for efficient and easy viewing of the files.

## Project is performed step by step covering every part of rubrics for review 2:
1. Core Feature Implementation
What Was Done:

Implemented all core banking operations:

User Registration

Login/Logout

Check Balance

Deposit and Withdraw Money

View Transaction History

Every feature is fully functional, tested, and integrated.

Uses clean method separation and file-based storage.

📌 2. Error Handling & Robustness
What Was Done:

Handled all possible user errors:

Invalid menu choices (e.g., letters instead of numbers)

Withdraw amount greater than balance

Empty username/password fields

Duplicate usernames

Prevents system crashes with try-catch blocks and custom messages.

📌 3. Integration of Components
What Was Done:

Different layers are perfectly integrated:

Main.java controls flow.

BankService handles business logic.

UserDAO manages user data.

FileManager handles file reading/writing.

All parts are modular and interact through clean, simple interfaces.

📌 4. Event Handling & Processing
What Was Done:

Each menu option behaves like an event handler.

Actions like deposit/withdraw are immediate and reflected in real time.

Designed for real-time user input and response handling using Scanner.

📌 5. Data Validation
What Was Done:

Ensures:

Valid inputs (no negative deposits/withdrawals).

Prevents overdraft.

Login credentials must match stored data.

Required fields must not be empty.

Uses helper methods for reusability and clarity in validation.

📌 6. Code Quality & Innovative Features
What Was Done:

Modular code with proper packages: model, dao, service, io.

Innovative Features:

Uses file-based storage for both user and per-user transaction records.

Auto-generates user transaction files like transactions_tanmay.txt.

Transaction timestamps for real-time logs.

Uses object-oriented principles like encapsulation and separation of concerns.

📌 7. Readability and Modularity of Code
What Was Done:

Code is split into:

User.java (Model)

UserDAO.java (Data Layer)

FileManager.java (IO Layer)

BankService.java (UI + Logic)

Well-commented, with class-level and method-level descriptions.

📌 8. Commenting and Inline Documentation
What Was Done:

Inline comments explain logic step by step.

Each method includes:

Purpose

Parameters

Return values

Helpful for evaluation and future maintenance.

📌 9. Prepare Project Documentation
What Was Done:

Full README.md file is created with:

Overview

Project structure

Setup instructions

Sample run output

Rubric mapping

## Explanation of Completed Tasks – Review 2
🔹 Core Feature Implementation
All essential banking operations — Register, Login, Check Balance, Deposit, Withdraw, View Transactions, and Logout — have been fully developed. Each feature integrates seamlessly into the application flow and produces expected output with persistence.

🔹 Error Handling and Robustness
The system uses try-catch blocks and input validations to gracefully handle:

Invalid menu choices
Wrong data types (e.g., string when number expected)
File I/O errors
Authentication failures
The application never crashes and instead gives the user clear feedback and instructions.

🔹 Integration of Components
The different layers of the application — model, dao, service, io, and main — are well-integrated:
The FileManager handles all file operations.
UserDAO retrieves and updates user data.
BankService manages user interactions and business logic.
Main.java connects everything and drives the menu-based interaction.
This separation of concerns ensures high cohesion and loose coupling.

🔹 Event Handling and Processing
Even in a console-based setup, user "events" (like selecting menu options, entering data) are processed effectively:
Every input is mapped to a clear logical function.
Incorrect or unexpected input triggers user-friendly error messages.
A clean loop-driven design allows for smooth transitions between different options like login, deposit, etc.

🔹 Data Validation
User inputs are rigorously validated:
Username and password cannot be empty.
Deposits and withdrawals must be positive numbers.
Withdrawals cannot exceed current balance.
All I/O operations check for file existence and correct format.

🔹 Code Quality and Innovative Features
The code follows best practices:
Modular design using packages
Comments throughout every class and method
Reusable methods
User-friendly prompts and real-time feedback
Innovative Features Added:
Transaction data is time-stamped using LocalDateTime.
Each user has a personalized transaction history file.
Menus auto-refresh after each action to improve user experience.
Auto-creation of files if they don’t exist (first-time use support).

🔹 Readability and Modularity
Classes are logically separated into packages (model, dao, io, service).
Functions are short and focused.
Naming conventions follow Java standards.
Comments added for each method for better understanding.

🔹 Completeness of Core Features
All features mentioned in the requirements and rubrics are fully working:
Multiple users can register and maintain individual accounts.
Transaction history is preserved even after logout or restart.
Files are automatically generated and updated at runtime.

🔹 Commenting and Inline Documentation
All major classes and methods include inline comments to explain logic and flow. This makes the code easy to read, debug, and extend.

🔹 Prepare Project Documentation
A complete README.md file has been prepared (as shown earlier), which includes:
Overview
Project Structure
Setup Instructions
Runtime Output
Explanation of Project Functionality

BY:
TANMAY SHARMA














