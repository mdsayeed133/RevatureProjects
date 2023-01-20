Banking App
The Banking App is a full stack application that allows users to manage their financial accounts and transactions. The app has a React frontend and a Spring backend, and utilizes AWS RDS for a centralized remote database.

Features
	User registration and login
	User profile management
	Tracking of income and expenses
	Transfer of money between different accounts
	Opening new saving or checking accounts
	
Technologies
	Spring Framework
	React
	AWS RDS
	Java 
	Postman
	PostgreSQL
	HTML
	CSS
	TypeScript
	JUnit
	
Getting Started
The source code for this app can be found in the following repository: https://github.com/mdsayeed133/RevatureProjects.git

To run this app, you will need to have the following tools installed on your system:
	Java JDK 19
	React
	Redux
	Spring Framework
	PostgreSQL
	AWS RDS
	Git Bash

You will also need to have an active AWS account to setup RDS.

Running the App
1. Clone the repository to your local machine
2. Configure the database connection settings in the Spring application.properties file with:
	server.port = 5555
	server.servlet.context-path = /bank
	spring.datasource.url = jdbc:postgresql://project2.citpuzbvuzos.us-east-1.rds.amazonaws.com:5432/postgres
	spring.datasource.username = postgres
	spring.datasource.password = itsnotpassword
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.properties.hibernate.default_schema=bankdb
3. Run the following command to start the Spring backend:

	./mvnw spring-boot:run
4.Install Redux in React-app runs these in gitBash:
	npm install react-router-dom --save
	npm install react-redux
	npm install redux
	npm i --save-dev @types/react-router-dom
	npm i axios
	npm install @reduxjs/toolkit

5. Run the following command to start the React frontend:

	npm start

6.The app will now be running on http://localhost:3000

Running the Tests
JUnit tests have been implemented for the backend services. To run the tests, use the following command:

	./mvnw test