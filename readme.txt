README - Customer Rewards Calculation API

Project Description
--------------------
This is a Spring Boot RESTful API for a Retail Customer Rewards Program. It tracks customer purchases and calculates monthly and total reward points based on transaction history.

Reward Calculation Rules
------------------------
- 1 point for every dollar spent over $50
- 2 points for every dollar spent over $100

Example:
For a $120 purchase:
- Over $100: (120 - 100) * 2 = 40 points
- Between $50–100: (100 - 50) * 1 = 50 points
- Total = 90 points

Tech Stack
----------
- Java 17+
- Spring Boot
- Spring Data JPA
- H2 in-memory database (can be swapped with MySQL/PostgreSQL)
- Maven

How to Run
----------
Prerequisites:
- JDK 17+
- Maven
- IDE : STS

The app will start on http://localhost:8080

API Endpoints
-------------

1. Add a Customer
   POST /api/customers/saveCustomer
   Request:
   {
     "name": "Alice"
   }
   Response:
   {
     "customerId": 1,
     "name": "Alice"
   }

2. Add a Transaction
   POST /api/transactions/{customerId}
   Request:
   {
     "amount": 120.0,
     "transactionDate": "2024-03-15"
   }
   Response:
   {
     "id": 1,
     "amount": 120.0,
     "transactionDate": "2024-03-15"
   }
3. Get All Customers
   GET /api/customer/getAllCustomer
   Response:
   [
     {
        "customerId": 1,
        "name": "Alice",
        "transactions": [1]
    }
   ]

3. Get Reward Summary for All Customers
   GET /api/rewards/get
   Response:
   [
     {
       "customerName": "Alice",
       "monthlyPoints": {
         "MARCH": 90,
         "APRIL": 110
       },
       "totalPoints": 200
     }
   ]

H2 Database Console
-------------------
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- Username: sa, Password: 


Folder Structure
----------------
src/main/java
├── controller
│   └── CustomerController, TransactionController, RewardsController
├── service
│   └── RewardService, TransactionService
├── model
│   └── Customer, Transaction, RewardResponse
├── repository
│   └── CustomerRepository, TransactionRepository
└── exception
    └── GlobalExceptionHandler, ResourceNotFoundException

Future Improvements
-------------------
- Add filtering by month/date range
- Add filtering by customerId
- Role-based authentication
- Pagination support
