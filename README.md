# Publication Management System

## Overview

The Publication Management System is a web-based application developed using Java, JDBC, Servlets, MySQL, HTML, and Tailwind CSS. The system helps manage student, faculty, and publication records efficiently while providing PDF report generation and download functionality.

---

## Features

### Student Management

* Add and manage student records.
* Store student information in the MySQL database.

### Faculty Management

* Add and manage faculty records.
* Maintain faculty publication details.

### Publication Management

* Record publication information.
* Associate publications with students and faculty.
* Store publication details using a relational database.

### PDF Report Generation

* Generate publication reports in PDF format.
* Download reports directly from the application.

### Database Integration

* MySQL database connectivity using JDBC.
* Foreign key relationships between tables.

### User Interface

* Responsive and user-friendly interface.
* Developed using HTML and Tailwind CSS.

---

## Technologies Used

### Frontend

* HTML
* Tailwind CSS

### Backend

* Java
* Servlets
* JDBC

### Database

* MySQL

### Server

* Apache Tomcat

### PDF Generation

* iText PDF Library

---

## Database Structure

The system uses three main tables:

1. Student
2. Faculty
3. Publication

The Publication table is linked with the Student and Faculty tables using foreign key relationships to maintain data integrity and establish associations between authors and publications.

---

## Setup Instructions

1. Clone the repository.
2. Import the project into Eclipse IDE.
3. Configure Apache Tomcat Server.
4. Create the MySQL database and required tables.
5. Add MySQL Connector JAR and iText PDF Library to the project.
6. Update the MySQL database username and password in the `DBConnection.java` file.
7. Run the project on Apache Tomcat Server.

---

## Project Objective

To provide a centralized platform for storing, managing, and generating reports for student and faculty research publications.

---

## Team Members

* Vedika Khadde
* Team Member

---

## Conclusion

This project demonstrates the implementation of Java Web Technologies, JDBC Connectivity, Relational Database Management, and PDF Report Generation in a real-world academic publication management system.
