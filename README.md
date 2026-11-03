# Digital Certificate Management System

## Project Description
The Digital Certificate Management System is a Java-based application developed using Java Swing and MySQL. It helps administrators issue, store, and verify digital certificates.

## Features
- Admin login
- Issue digital certificates
- Store certificate details in MySQL database
- Verify certificates using a unique Verification ID
- Generate certificates in PDF format
- Generate QR codes containing the Verification ID

## Technologies Used
- Java
- Java Swing
- MySQL
- JDBC
- OpenPDF
- ZXing QR Code Library
- Apache NetBeans
 

## 4. Project Structure

```text
DigitalCertificateSystem/
│
├── src/
│   └── certificate/
│       ├── Certificate.java
│       ├── CertificateDAO.java
│       ├── DBConnection.java
│       ├── Main.java
│       ├── PDFGenerator.java
│       ├── QRGenerator.java
│       ├── QRGeneratorTest.java
│       │
│       └── ui/
│           ├── LoginFrame.java
│           ├── MainFrame.java
│           ├── MainFrame.form
│           ├── IssueCertificate.java
│           ├── IssueCertificate.form
│           ├── VerifyCertificate.java
│           └── VerifyCertificate.form
│
├── nbproject/
├── dist/
├── build.xml
└── manifest.mf
```


## Database Setup

1. Install MySQL.
2. Create a database:
CREATE DATABASE certificate_db;
3. Select the database:
USE certificate_db;
4. Create the certificates table:
CREATE TABLE certificates (
    verification_id VARCHAR(100) PRIMARY KEY,
    certificate_number VARCHAR(50) UNIQUE NOT NULL,
    recipient_name VARCHAR(150) NOT NULL,
    course_name VARCHAR(150) NOT NULL,
    issue_date DATE NOT NULL
);
5. Configure your MySQL username and password in DBConnection.java.
 
   
## Required Libraries
Add the following libraries to the NetBeans project:
MySQL Connector/J
OpenPDF
ZXing Core


## How to Run
1. Open the project in Apache NetBeans.
2. Configure MySQL and create the `certificate_db` database.
3. Add the required library JAR files.
4. Update the database connection details in `DBConnection.java`.
5. Run `Main.java`.

## Admin Login
- Username: `admin`
- Password: `admin123`

## Application Workflow
1. Admin logs into the application.
2. Admin enters certificate details.
3. Certificate information is stored in MySQL.
4. A PDF certificate is generated with a QR code.
5. The certificate can be verified using its Verification ID.


## Project Purpose
This project demonstrates certificate management, database connectivity, PDF generation, and QR-based certificate identification.


## Developed as a Java Project.
