# Banking Management System

This project is a **Banking Management System** built using **Spring Boot** for the backend and **React** for the frontend. The application allows users to manage their loans, transactions, and user profiles seamlessly.

## Features

- **User Management**: Register, log in, and manage user profiles.
- **Loan Management**: Apply for loans, view loan status, and manage loan payments.
- **Transaction Management**: Make loan payments and view transaction history.
- **Admin Features**: View all loans and manage loan statuses.

## Technologies Used

- **Backend**:
  - Spring Boot
  - Spring Security
  - MySQL
- **Frontend**:
  - React
  - Axios
  - Tailwind CSS
- **Development Tools**:
  - Postman (for API testing)
  - IntelliJ IDEA / Eclipse (for backend development)

## Setup Instructions

### Prerequisites

- JDK 11 or later
- MySQL Server
- Node.js and npm
- Maven (for backend dependency management)

### Backend Setup

1. Clone the repository:

   git clone <repository-url>
   cd bankingManagementSystem

   Configure the MySQL database:

2. Create a database named banking_management_system.
   Update the application.properties file with your database credentials:
   properties

spring.datasource.url=jdbc:mysql://localhost:3306/banking_management_system
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
Build and run the backend

mvn clean install
mvn spring-boot:run

### Frontend Setup

1. Navigate to the frontend directory

cd frontend 2. Install the dependencies

npm install 3. Start the React application

npm start

### API Endpoints

User Endpoints
Register User

POST /api/register
Login User

POST /api/login
Get User by ID

GET /api/users/{userId}
Update User Profile

PUT /api/users/{userId}
Delete User

DELETE /api/users/{userId}
Get All Users

GET /api/users
Loan Endpoints
Apply for Loan

POST /api/loans/apply/{userId}
Get Loan by ID

GET /api/loans/{loanId}
Get All Loans by User ID

GET /api/loans/user/{userId}
Get Loan Status

GET /api/loans/{loanId}/status
Update Loan Status

PUT /api/loans/{loanId}/status?status={status}
Calculate Monthly Payment

GET /api/loans/{loanId}/monthly-payment
Get All Pending Loans

GET /api/loans/pending
Get All Loans

GET /api/loans/view
Transaction Endpoints
Make Loan Payment

POST /api/payments
Get All Transactions by Loan ID

GET /api/loans/{loanId}/transactions
Calculate Remaining Balance

GET /api/loans/{loanId}/remaining-balance

### Usage

Once the backend and frontend are running, you can access the application at http://localhost:3000. You can register a new user, log in, apply for loans, make payments, and view your transaction history.

Contributing
Contributions are welcome! If you have suggestions or improvements, please create a pull request.

License
This project is licensed under the MIT License - see the LICENSE file for details.

### Author - Nima Sherpa

### Notes

- Replace `<repository-url>` with the actual URL of your GitHub repository and update the MySQL database credentials in the setup instructions.
- This format is designed for easy copying and pasting without breaks.
