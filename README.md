# Online-Banking-System-Review-2

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

ConsoleBankingSystem/
#Main.java # Main entry point to launch the app
├── model/
│ └── User.java # User class containing user attributes
├── dao/
│ └── UserDAO.java # Handles user data CRUD operations
├── service/
│ └── BankService.java # Business logic for banking functions
├── io/
│ └── FileManager.java # File I/O operations (users + transactions)
└── users.txt # Stores registered users
└── transactions_<username>.txt # Individual user transaction history



